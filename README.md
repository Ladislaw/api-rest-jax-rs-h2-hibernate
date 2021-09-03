# api-rest-jax-rs-h2-hibernate
Desafio api jax-rs

Projeto simples com o intuito de construír uma api rest contendo 2 endpoints, um para fazer o cadastro de um objeto pessoa e outro para consultar esse objeto cadastrado
por NOME ou CPF.

A api rest utiliza do framework Jersey da Sun que implementa o JAX-RS que define como uma aplicação rest deve ser.

Stack: Maven, Tomcat, Jersey, Hibernate, H2database, JUnit.

IDE utilizada: Eclipse.

Primeiro passo criar um projeto "Dynamic Web Aplication", lembrando de dar um checked para criar o arquivo web.xml onde será configurado o servelet em que o Jersey 
estará trabalhando com as requisições.

Converter o projeto para um projeto Maven e adicionar as depêndencias necessárias do Jersey, Hibernate, H2database e Junit no arquivo pom.xml.

Configuração do arquivo web.xml adicionando as tags de configuração <servelet> e <servelet-mapping> que são responsáveis por apontar o package que estarão as classes
que terão os endpoints da aplicação.

Criar uma pasta ./src/main/resources e adicionar o arquivo hibernate.cfg.xml que é responsável pela configuração do Hibernate e a conexão com o banco de dados H2database.

Criar uma classe aplicando o padrão Singleton que será responsável por fornecer um objeto que permitirar a interação com o banco de dados.

Configurar o servidor de aplicação apache Tomcat e adicionar o modulo do projeto ao servidor.

Pronto, todas as configuraçõe necessárias feitas, hora de meter a mão na massa.
