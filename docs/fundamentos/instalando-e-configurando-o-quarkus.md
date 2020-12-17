# Instalando e configurando o Quarkus

## Instalando a GraalVM no linux

Baixe o último release indicado pelo quarkus na página de releases do [github](https://github.com/oracle/graal/releases) do GraalVM e extraia no seu computador:

```bash
curl -L https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java11-linux-amd64-20.2.0.tar.gz \-o graalvm-ce-java11-linux-amd64-20.2.0.tar.gz

tar -xvzf graalvm-ce-java11-linux-amd64-20.2.0.tar.gz
```

Como usuário root crie a pasta `jvm` dentro de `/usr/lib`, caso ainda não exista, e mova a pasta do GraalVM para `/usr/lib/jvm`:

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

## Configurando o GraalVM Component Updater

O GraalVM Component Updater\(gu\) é uma ferramente de linha de comando para instalar componentes na GraalVM, para utilizar o gu basta adicionar ao `.bashrc` a seguinte entrada:

```bash
export GRAALVM_HOME="/usr/lib/jvm/graalvm-ce-java11-20.2.0"
export PATH=$GRAALVM_HOME/bin:$PATH
```

## Instalando o Native Image

Native Image é uma tecnologia para compilar antecipadamente o código Java em um executável independente, chamado de `native image`. Esse executável inclui as classes de aplicativo, classes de suas dependências, classes de biblioteca de tempo de execução e código nativo vinculado estaticamente do JDK.

Ele não é executado no Java VM, mas inclui componentes necessários, como gerenciamento de memória, agendamento de thread e assim por diante, de um sistema de tempo de execução diferente, chamado “Substrate VM”.

Substrate VM é o nome dos componentes de tempo de execução \(como desotimizador, coletor de lixo, agendamento de thread, etc.\). O programa resultante tem um tempo de inicialização mais rápido e menor sobrecarga de memória de tempo de execução em comparação com uma JVM. Para adicionar a instalação da GraalVM basta rodar o seguinte comando:

```bash
gu install native-image
```

