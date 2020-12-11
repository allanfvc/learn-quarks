# Hello, World

[O código fonte deste capítulo pode ser encontrado aqui.](../../src/hello-world)

Como tradicionalmente no aprendizado de tecnologias de programação, o primeiro programa é uma `Hello, World`. Para iniciar um projeto Quarkus abra o terminal e digite:

{% tabs %}
{% tab title="Maven" %}
```bash
mvn io.quarkus:quarkus-maven-plugin:1.10.3.Final:create \
    -DprojectGroupId=<group-id> \
    -DprojectArtifactId=<artifact-id> \
    -DclassName="<group-id>.<java-class>" \
    -Dpath="<path>"
```
{% endtab %}
{% tab title="Gradle" %}
```bash
mvn io.quarkus:quarkus-maven-plugin:1.10.3.Final:create \
    -DprojectGroupId=<group-id> \
    -DprojectArtifactId=<artifact-id> \
    -DclassName="<group-id>.<java-class>" \
    -Dpath="<path>"
    -DbuildTool=gradle
```
{% endtab %}
{% endtabs %}

Onde ***\<group-id\>*** é o id da organização, ***\<artifact-id\>***  é o nome do projeto que será gerado, ***\<java-class\>*** é utilizado para definir a classe inicial criada pelo plugin com um código de exemplo para iniciar o desenvolvimento e o ***\<path\>*** determinar o endpoint que irá representar a classe inicial.

## Como testar

Todo código da aplicação deve se encontrar em `src/main/<group-id>` e o código de testes deve ser localizado em `src/test/<group-id>`. Sempre que um pacote é criado em `src/main/<group-id>` deve-se criar o mesmo pacote em `src/test/<group-id>` isto ajuda na organização dos códigos de teste.

Crie uma classe de testes `HelloResourceTest` em `src/test/<group-id>` e adicione a anotação `@QuarkusTest` do pacote `io.quarkus.test.junit`. Dentro da classe crie uma função com o nome `testHelloEndpoint` e adicione ao método a anotação `@Test` do pacote `org.junit.jupiter.api`.

```java
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class HelloResourceTest {

  @Test
  public void testHelloEndpoint() {

  }
}
```

Neste exemplo é usado o pacote [RESTassured](https://rest-assured.io/) que é integrado ao Quarkus e vem como padrão ao executar o comando de criação mostrado acima. O RESTassured facilita na criação e leitura de testes com uma sintaxe semelhante a utilizada na linguagem gherkin, seguindo um fluxo dado que, quando e então(given, when, then) para determinar o que acontece no teste.

A função estática `io.restassured.RestAssured.given` inicia o teste definindo os parâmetros da sua execução, ou definindo o estado inicial do teste, retornando o objeto `RequestSpecification` que contém o contexto do teste. Depois de definido o estado inicial do teste é determinada qual a ação que será executada sobre esse estado, que é a método `when()` do objeto `RequestSpecification`. Por fim basta conferir se o resultado obtido é o mesmo que o esperado, o termo `então`, utilizando o método `then()` do objeto `RequestSpecification`. Por exemplo: 
```java
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
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
}
```

