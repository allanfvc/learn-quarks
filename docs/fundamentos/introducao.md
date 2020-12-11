# Introdução

## O que é quarkus?

Citando diretamente a RedHat:

> Quarkus é um framework Java nativo em Kubernetes e de stack completo que foi desenvolvido para máquinas virtuais Java \(JVMs\) e compilação nativa. Ele otimiza essa linguagem especificamente para containers, fazendo com que essa tecnologia seja uma plataforma eficaz para ambientes serverless, de nuvem e Kubernetes.
>
> O Quarkus foi desenvolvido para funcionar com os padrões, frameworks e bibliotecas Java mais utilizados, como o Eclipse MicroProfile e o Spring \(demonstrados em conjunto nesta apresentação do Red Hat Summit 2020\), além do Apache Kafka, RESTEasy \(JAX-RS\), Hibernate ORM \(JPA\), Infinispan, Camel e muitos outros.
>
> A solução de injeção de dependência do Quarkus é baseada em Contexts and Dependency Injection \(CDI\). Além disso, ela inclui um framework de extensão para ampliar a funcionalidade e configurar, inicializar e integrar frameworks na sua aplicação. Adicionar uma extensão é tão fácil quanto adicionar uma dependência. Se preferir, você também pode usar as ferramentas do Quarkus.
>
> Ele também oferece as informações corretas ao GraalVM \(uma máquina virtual universal para executar aplicações escritas em diversas linguagens, incluindo Java e JavaScript\) para compilação nativa da aplicação.

## Porquê usar quarkus?

No desenvolvimento cloud native, o tempo de início de uma aplicação, a quantidade de memória consumida e o tamanho de imagens de containers são considerados críticos no ciclo de vida de microserviços.

O Quarkus foi criado priorizando containers, visando combater agilizar a entrega em ambientes de nuvem, como kubernetes por exemplo. Segundo a RedHat o quarkus conseque compilar aplicações consumindo um décimo da memória de uma aplicação java tradicional. Para isso o Quarks se utiliza de uma algumas técnicas e tecnologias:

* Compatibilidade avançada com Graal/SubstrateVM;
* Processamento de metadados em tempo de compilação;
* Redução no uso de reflexão;
* Pré-inicialização de imagens nativas;
* Desenvolvimento reativo não bloqueante

O Quarkus é uma solução eficaz para executar o Java neste novo mundo de arquitetura serverless, microsserviços, containers, Kubernetes, função como serviço \(FaaS\) e nuvem, pois ele foi criado levando todas essas tecnologias em consideração.

