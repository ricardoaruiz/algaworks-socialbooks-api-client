package com.algaworks.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.client.domain.Livro;
import com.algaworks.socialbooks.utils.RestBuilder;

public class Aplicacao {

	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) throws ParseException {
		
		LivrosClient cliente = new LivrosClient("http://localhost:8080", "algaworks", "s3nh4");
		
		Livro livro = new Livro();
		livro.setNome("Rest aplicado");
		livro.setEditora("AlgaWorks");
		livro.setPublicacao(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2016"));
		livro.setResumo("Este livro aborda o Git");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
		
		List<Livro> listaLivros = cliente.listar();
		
		for(Livro livro1 : listaLivros){
			System.out.println("Livro: " + livro1.getNome());
		}
		
		Livro livroEncontrado = cliente.buscar(localizacao);
		
		System.out.println("Livro encontrado: " + livroEncontrado.getNome());
			
		
		//TESTE do Builder
		livro.setNome("Livro criado pelo builder123");
		ResponseEntity<Void> responseLivroCriado = new RestBuilder() //
			.post()//
			.url("http://localhost:8080/livros")//
			.header("Authorization", getBasicAuthorization("algaworks", "s3nh4"))//
			.body(livro)//
			.call();
		
		ResponseEntity<Livro> response = new RestBuilder() //
			.get() //
			.url(responseLivroCriado.getHeaders().getLocation().toString())//
			.header("Authorization", getBasicAuthorization("algaworks", "s3nh4"))//
			.object(Livro.class)
			.call();
		
		System.out.println("Livro encontrado pelo builder: " + response.getBody().getNome());
		
		ResponseEntity<Livro[]> livros = new RestBuilder() //
				.get()//
				.url("http://localhost:8080/livros")//
				.header("Authorization", getBasicAuthorization("algaworks", "s3nh4"))//
				.object(Livro[].class)
				.call();
				
		for(Livro l : livros.getBody()){
			System.out.println(l.getNome());
		}
		
	}
	
	private static String getBasicAuthorization(String usuario, String senha){
		String credencialAux = usuario + ":" + senha;
		return "Basic " + Base64Utils.encodeToString(credencialAux.getBytes());
	}
	
}
