# Hello, World

[O código fonte deste capítulo pode ser encontrado aqui.](src/hello-world)

Como tradicionalmente no aprendizado de tecnologias de programação, o primeiro programa é uma `Hello, World`. Para iniciar um projeto Quarkus abra o terminal e digite:

```bash
mvn io.quarkus:quarkus-maven-plugin:1.10.3.Final:create \
    -DprojectGroupId=<group-id> \
    -DprojectArtifactId=<articfact-id> \
    -DclassName="<group-id>.<java-class>" \
    -Dpath="/hello"
cd <articfact-id>
```
