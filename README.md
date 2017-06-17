#Processo seletivo para Desenvolvedor Java
Repositório para armazenar as aplicações desenvolvidas para o processo seletivo para desenvolvedor java

#Frameworks e ferramentas utilizadas
O projeto foi desenvolvido utilizando os seguintes tecnologias:
- Java 8
- Spring Boot
- Tomcat embutido
- Swagger
- Maven
- JUNIT

#Arquitetura do projeto
- Ambiente de execução embutido - Utilizado o Tomcat embutido, disponibilizado pelo SpringBoot.
- REST - Esta aplicação disponibiliza um serviço REST para fazer o input da Stream. Recebe consome e responde no formato JSON.

#Pré requisitos
- Java 8
- Maven
	
#Configurações

Os arquivos de propriedades da aplicação se encontram no caminho: src/main/resources

A aplicação está configurada para subir na porta 8083. Caso haja necessidade de alterar esta porta é só alterar o número dela na propriedade server.port do arquivo Application.properties.

#Execução do projeto
Maven: $ mvn clean package spring-boot:run

Utilizando uma IDE: Executar a classe /streamleitura/src/main/java/br/com/tgolopes/LeituraStreamApplication.java


No seu browser digite http://localhost:8083/swagger-ui.html por aqui você verá a documentação dos serviços da API.