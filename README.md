# Phrase-JSF Application

Aplicacao desenvolvida com JSF 2.2, PrimeFaces 6.2, CDI, JPA (Hibernate) e arquitetura baseada em Clean Architecture, Hexagonal Architecture e principios SOLID.

## Stack Principal

* Java 8
* JSF 2.2
* PrimeFaces 6.2
* CDI 1.2
* WildFly 10.1
* Docker & Docker Compose
* Lombok

##  Como subir o projeto com Docker

1. Compile o projeto:

```bash
mvn clean package
```

2. Suba os containers:

```bash
docker-compose up --build
```

2.1. Desligar os containers:

```bash
docker-compose down
```

Quando subir o coker, irá subir:

* `MySQL`: em `localhost:3306`
* `WildFly`: em `localhost:8080` com debug em `8787`

## Hot Deploy (sem reiniciar o container)

Após compilar:

```bash
mvn clean package
```

Rode:

```bash
docker cp target/phrase-jsf.war wildfly10:/opt/jboss/wildfly/standalone/deployments/
```

Isso substitui o `.war` dentro do WildFly rodando no container.

##  Debug remoto com IntelliJ

1. Em IntelliJ, acesse:
   `Run > Edit Configurations > + > Remote JVM Debug`

2. Configure:

    * **Host**: `localhost`
    * **Port**: `8787`

3. Clique em `Debug`

Ao acessar a aplicação e atingir um breakpoint, o IntelliJ deve parar normalmente.

##  Dados do Banco

* **Host**: `localhost`
* **Porta**: `3306`
* **Banco**: `phraseapp`
* **Usuário**: `phrase`
* **Senha**: `phrase`

##  Endereços

* Acesso App: [http://localhost:8080/phrase-jsf](http://localhost:8080/phrase-jsf)
* Admin WildFly: [http://localhost:9990](http://localhost:9990)

## Estrutura do Projeto

```
br.com.prover.phrasejsf
|
├── application
│   └── usecase
│       └── AnalyzePhraseUseCase.java
|
├── domain
│   ├── model
│   │   └── PhraseAnalysis.java
│   └── service
│       └── PhraseAnalyzer.java
|
├── adapter
│   ├── web
│   │   └── PhraseBean.java
|
├── port
│   ├── input
│   │   └── AnalyzePhraseInputPort.java
│   
```

## Features

* Análise de frases

    * Quantidade de palavras distintas
    * Contagem de ocorrências
* Integração com JSF + PrimeFaces

---
