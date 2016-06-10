package com.algaworks.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.client.domain.Livro;

public class Aplicacao {

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
				
	}
	
}
