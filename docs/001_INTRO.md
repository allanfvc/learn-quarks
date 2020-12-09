
# 1. Introdução
## 1.1. O que é quarkus?
---
Citando diretamente a RedHat:

    Quarkus é um framework Java nativo em Kubernetes e de stack completo que foi desenvolvido para máquinas virtuais Java (JVMs) e compilação nativa. Ele otimiza essa linguagem especificamente para containers, fazendo com que essa tecnologia seja uma plataforma eficaz para ambientes serverless, de nuvem e Kubernetes.

    O Quarkus foi desenvolvido para funcionar com os padrões, frameworks e bibliotecas Java mais utilizados, como o Eclipse MicroProfile e o Spring (demonstrados em conjunto nesta apresentação do Red Hat Summit 2020), além do Apache Kafka, RESTEasy (JAX-RS), Hibernate ORM (JPA), Infinispan, Camel e muitos outros.

    A solução de injeção de dependência do Quarkus é baseada em Contexts and Dependency Injection (CDI). Além disso, ela inclui um framework de extensão para ampliar a funcionalidade e configurar, inicializar e integrar frameworks na sua aplicação. Adicionar uma extensão é tão fácil quanto adicionar uma dependência. Se preferir, você também pode usar as ferramentas do Quarkus.

    Ele também oferece as informações corretas ao GraalVM (uma máquina virtual universal para executar aplicações escritas em diversas linguagens, incluindo Java e JavaScript) para compilação nativa da aplicação.


## 1.2. Porquê usar quarkus?
---

No desenvolvimento cloud native, o tempo de início de uma aplicação, a quantidade de memória consumida e o tamanho de imagens de containers são considerados críticos no ciclo de vida de microserviços.

O Quarkus foi criado priorizando containers, visando combater agilizar a entrega em ambientes de nuvem, como kubernetes por exemplo. Segundo a RedHat o quarkus conseque compilar aplicações consumindo um décimo da memória de uma aplicação java tradicional. Para isso o Quarks se utiliza de uma algumas técnicas e tecnologias:

  * Compatibilidade avançada com Graal/SubstrateVM
  * Processamento de metadados em tempo de compilação
  * Redução no uso de reflexão
  * Pré-inicialização de imagens nativas
  * Desenvolvimento reativo não bloqueante

O Quarkus é uma solução eficaz para executar o Java neste novo mundo de arquitetura serverless, microsserviços, containers, Kubernetes, função como serviço (FaaS) e nuvem, pois ele foi criado levando todas essas tecnologias em consideração. 

## 1.3. Instalando e configurando o quarkus
---
Neste capítulo será descrito o que é necessário para se começar a desenvolver utilizando o quarks. Mostrando como se instalar a GraalVM em um sistema linux e configurar para desenvolvimento nativo. Os passos necessário para utilizar os quarkus podem ser encontrados em https://quarkus.io/get-started/.

### 1.3.1 Instalando a GraalVM no linux
Baixe o último release indicado pelo quarkus na página de releases do [github](https://github.com/oracle/graal/releases) do GraalVM e extraia no seu computador:
```bash
curl -L https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java11-linux-amd64-20.2.0.tar.gz -o graalvm-ce-java11-linux-amd64-20.2.0.tar.gz

tar -xvzf graalvm-ce-java11-linux-amd64-20.2.0.tar.gz
```

Como usuário root crie a pasta `jvm` dentro de `/usr/lib`, caso ainda não exista, e mova a pasta do GraalVM para `/usr/lib/jvm`:
```bash
mkdir -p /usr/lib/jvm

mv graalvm-ce-java11-20.2.0/ /usr/lib/jvm/
```

```bash
mkdir -p /usr/lib/jvm

mv graalvm-ce-java11-20.2.0/ /usr/lib/jvm/
```

Adicione uma nova configuração ao `alternatives`, e então adicione o graalvm como alternativa do java:
```bash
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/graalvm-ce-java11-20.2.0/bin/java 1
```
Por fim basta rodar o comando `update-alternatives --config java` para selecionar o GraalVM:

```bash
update-alternatives --config java

Há 1 programa que oferece "java".

  Seleção    Comando
-----------------------------------------------
*+ 1           /usr/lib/jvm/graalvm-ce-java11-20.2.0/bin/java

Indique para manter a seleção atual[+] ou digite o número da seleção: 1
```

### 1.3.2 Configurando o GraalVM Component Updater

O GraalVM Component Updater(gu) é uma ferramente de linha de comando para instalar componentes na GraalVM, para utilizar o gu basta adicionar ao `.bashrc` a seguinte entrada:

```bash
export GRAALVM_HOME="/usr/lib/jvm/graalvm-ce-java11-20.2.0"
export PATH=$GRAALVM_HOME/bin:$PATH
```

### 1.3.3 Instalando o Native Image
Native Image é uma tecnologia para compilar antecipadamente o código Java em um executável independente, chamado de `native image`. Esse executável inclui as classes de aplicativo, classes de suas dependências, classes de biblioteca de tempo de execução e código nativo vinculado estaticamente do JDK. Ele não é executado no Java VM, mas inclui componentes necessários, como gerenciamento de memória, agendamento de thread e assim por diante, de um sistema de tempo de execução diferente, chamado “Substrate VM”. Substrate VM é o nome dos componentes de tempo de execução (como desotimizador, coletor de lixo, agendamento de thread, etc.). O programa resultante tem um tempo de inicialização mais rápido e menor sobrecarga de memória de tempo de execução em comparação com uma JVM. Para adicionar a instalação da GraalVM basta rodar o seguinte comando:
```bash
gu install native-image
```
