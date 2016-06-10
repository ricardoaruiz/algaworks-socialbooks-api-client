Treinamento Web Services RESTful e Spring

<b>Aula 4.2</b> - Cliente Java

- Foi criado um projeto Maven e inseridas as seguintes dependências:

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.2.5.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.7.2</version>
    </dependency>

<b>Aula 4.3</b> - Evoluindo nosso cliente Java

- Criamos a classe "LivrosClient" com os métodos "listar" e "salvar" chamando a API utilizando RestTemplate.