package com.algaworks.socialbooks.aplicacao;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Livro {

  private Long id;

  private String nome;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date publicacao;

  private String editora;

  private String resumo;

  private List<Comentario> comentarios;

  private Autor autor;

  public Livro() {

  }

  public Livro(String nome) {
    super();
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getPublicacao() {
    return publicacao;
  }

  public void setPublicacao(Date publicacao) {
    this.publicacao = publicacao;
  }

  public String getEditora() {
    return editora;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public List<Comentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public String getResumo() {
    return resumo;
  }

  public void setResumo(String resumo) {
    this.resumo = resumo;
  }

}
