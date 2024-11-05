API de Cadastro de Eventos e Cupons

Este projeto é uma API desenvolvida em Java com Spring Boot, voltada para o cadastro e gerenciamento de eventos e cupons de desconto. Utiliza um banco de dados PostgreSQL, com gerenciamento de migrações realizado pelo Flyway.

Alguns serviços da AWS também foram integrados para armazenamento e testes. Abaixo, mais detalhes sobre a configuração e os recursos utilizados.

## Tecnologias Utilizadas

- <img src="https://img.shields.io/badge/-Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" height="20"/> Linguagem principal do projeto.
- <img src="https://img.shields.io/badge/-Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" height="20"/> Framework para a criação da API REST.
- <img src="https://img.shields.io/badge/-PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" height="20"/> Banco de dados relacional para armazenamento de dados.
- <img src="https://img.shields.io/badge/-Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white" height="20"/> Ferramenta de migrações para controle de versões do banco de dados.
- <img src="https://img.shields.io/badge/-AWS%20CLI-FF9900?style=for-the-badge&logo=amazon-aws&logoColor=white" height="20"/> Interface de linha de comando para interagir com os serviços da AWS.
- <img src="https://img.shields.io/badge/-Amazon%20S3-569A31?style=for-the-badge&logo=amazon-s3&logoColor=white" height="20"/> **S3**: Serviço de armazenamento utilizado para armazenar arquivos relacionados ao projeto.
- <img src="https://img.shields.io/badge/-Amazon%20RDS-527FFF?style=for-the-badge&logo=amazon-rds&logoColor=white" height="20"/> **RDS**: Serviço de banco de dados relacional para hospedar o PostgreSQL (atualmente desabilitado).
- <img src="https://img.shields.io/badge/-Springdoc%20API-8A5B8A?style=for-the-badge&logo=spring&logoColor=white" height="20"/> **Springdoc API**: Biblioteca para gerar documentação de APIs usando Swagger com Spring.
- <img src="https://img.shields.io/badge/-Git-F05032?style=for-the-badge&logo=git&logoColor=white" height="20"/> **Git**: Sistema de controle de versão distribuído para gerenciar o código-fonte.


O projeto está organizado da seguinte forma:

- `src/main/java`: Contém o código fonte Java do projeto.
- `src/main/resources`: Contém arquivos de configuração, incluindo o `application.properties` e scripts de migração Flyway.

## Configuração e Execução

### Pré-requisitos

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) (versão 11 ou superior)
- ![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) para o gerenciamento de dependências e build
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white) para o banco de dados local

## Documentação da API

A documentação da API pode ser acessada através do Swagger UI em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).


## Observações

O projeto inicialmente foi está configurado para utilizar o serviço S3 para armazenar arquivos. Certifique-se de ter as credenciais AWS configuradas em variáveis de ambiente ou no application.properties.
Os serviços EC2 e RDS foram configurados apenas para testes inicialmente e, atualmente, estão desabilitados.
