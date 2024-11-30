# Gerenciador de Livros

## Descrição

O **Gerenciador de Livros** é um sistema para gerenciar livros, autores e assuntos, desenvolvido com **Java 17**, **Spring 3.4** e **Angular 19**. O servidor de aplicação é baseado no **Spring Boot**, com o banco de dados em memória **H2** e integração com **Flyway** para migrações automáticas.

## Funcionalidades

- **Manter livros**: Cadastro, edição e exclusão de livros.
- **Manter autores**: Cadastro e gerenciamento de autores.
- **Manter assuntos**: Cadastro e gerenciamento de assuntos.
- **Autocomplete de autor**: Sugestões de autores durante a inserção de dados.
- **Autocomplete de assunto**: Sugestões de assuntos durante a inserção de dados.
- **Relatório de livros**: Geração de relatórios utilizando **JasperReports**.

## Requisitos Funcionais

- Manter livros.
- Manter autores.
- Manter assuntos.
- Autocomplete de autor.
- Autocomplete de assunto.
- Relatório de livros com **JasperReports**.

## Requisitos Não Funcionais

- **Java 17**.
- **H2** (banco de dados).
- **Git**.
- **Flyway** para migração de banco de dados.
- **Spring Boot**.
- **Hibernate** e **JPA** para persistência de dados.
- **JasperReports** para geração de relatórios.
- **JUnit** para testes unitários.
- **Swagger** para documentação de APIs.

## Frontend

O frontend da aplicação está disponível no seguinte repositório:

[Frontend - Gerenciador de Livros](https://github.com/Rayldon/front-gerenciador-de-livros)

## Dependências

- **Spring Boot**: Framework principal para desenvolvimento da aplicação.
- **H2**: Banco de dados em memória utilizado para armazenar os dados.
- **Flyway**: Ferramenta para migração de banco de dados.
- **JasperReports**: Framework para geração de relatórios.
- **JUnit**: Framework de testes unitários.
- **Swagger**: Documentação da API.

## Como Contribuir

Faça um fork deste repositório, crie uma branch para a sua feature (`git checkout -b feature/nome-da-feature`), faça commit das suas alterações (`git commit -am 'Adicionando nova feature'`), envie para a branch (`git push origin feature/nome-da-feature`) e abra um Pull Request.
