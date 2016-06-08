package com.algaworks.socialbooks.aplicacao;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResourceError {

  @JsonInclude(Include.NON_EMPTY)
  private String titulo;

  private Long status;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private Date data;

  private String ajuda;

  @JsonInclude(Include.NON_EMPTY)
  private List<ResourceDetailError> detalhes;


  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getAjuda() {
    return ajuda;
  }

  public void setAjuda(String mensagemDesenvolvedor) {
    this.ajuda = mensagemDesenvolvedor;
  }

  public List<ResourceDetailError> getDetalhes() {
    return detalhes;
  }

  public void setDetalhes(List<ResourceDetailError> detalhes) {
    this.detalhes = detalhes;
  }

}
