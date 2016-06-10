package com.algaworks.socialbooks.client.domain;

public class ResourceDetailError {

  private String campo;

  private String causa;

  public ResourceDetailError(String campo, String causa) {
    this.campo = campo;
    this.causa = causa;
  }

  public String getCampo() {
    return campo;
  }

  public void setCampo(String campo) {
    this.campo = campo;
  }

  public String getCausa() {
    return causa;
  }

  public void setCausa(String causa) {
    this.causa = causa;
  }

}
