package com.algaworks.socialbooks.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestBuilder {

  private static final String RETURN_OBJECT = "return-object";

  private static final String BODY = "body";

  private static final String HTTP_METHOD = "http-method";

  private static final String URL = "url";

  HttpHeaders headers = new HttpHeaders();

  private Map<String, Object> build = new HashMap<String, Object>();

  public RestBuilder url(String url) {
    build.put(URL, url);
    return this;
  }

  public RestBuilder get() {
    build.put(HTTP_METHOD, HttpMethod.GET);
    return this;
  }

  public RestBuilder patch() {
    build.put(HTTP_METHOD, HttpMethod.PATCH);
    return this;
  }

  public RestBuilder post() {
    build.put(HTTP_METHOD, HttpMethod.POST);
    return this;
  }

  public RestBuilder put() {
    build.put(HTTP_METHOD, HttpMethod.PUT);
    return this;
  }

  public RestBuilder delete() {
    build.put(HTTP_METHOD, HttpMethod.DELETE);
    return this;
  }

  public RestBuilder header(String key, String value) {
    headers.set(key, value);
    return this;
  }

  public RestBuilder body(Object body) {
    build.put(BODY, body);
    return this;
  }

  public RestBuilder type(MediaType type) {
    headers.setContentType(type);
    return this;
  }

  @SuppressWarnings("rawtypes")
  public RestBuilder object(Class clazz) {
    build.put(RETURN_OBJECT, clazz.getName());
    return this;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public ResponseEntity call() {

    try {             
      return new RestTemplate(new HttpComponentsClientHttpRequestFactory()).exchange(getUrl(), getHttpMethod(), getRequest(), getReturnClass());
    } catch (ClassNotFoundException e) {
      //TODO Logar o erro
    }

    return null;

  }
  
  private String getUrl(){
	return (String) build.get(URL); 
  }
  
  private HttpMethod getHttpMethod() {
	return (HttpMethod) build.get(HTTP_METHOD);	  
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private HttpEntity getRequest() {
	HttpEntity request;
	Object body = build.get(BODY);
	if (body != null) {
	  if (!headers.containsKey("Content-Type")) {
	      headers.setContentType(MediaType.APPLICATION_JSON);
	  }
	  request = new HttpEntity(body, headers);
	} else {
	  request = new HttpEntity(headers);
	}
	return request;
  }
  
  @SuppressWarnings("rawtypes")
  private Class getReturnClass() throws ClassNotFoundException{
	  return build.get(RETURN_OBJECT) == null ? Void.class : Class.forName(build.get(RETURN_OBJECT).toString());
  }

}