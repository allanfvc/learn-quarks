package io.github.allanfvc;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.apache.http.HttpStatus;

@QuarkusTest
public class HelloResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
      .when().get("/hello")
      .then()
        .statusCode(HttpStatus.SC_OK)
        .body(is("Hello World!"));
  }

  @Test
  public void testHelloEndpointWithName() {
    given()
      .param("name", "Allan")
      .when().get("/hello")
      .then()
        .statusCode(HttpStatus.SC_OK)
        .body(is("Hello Allan!"));
  }
  
}
