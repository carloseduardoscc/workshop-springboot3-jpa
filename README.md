# Workshop Spring Boot 3 + JPA

Este projeto é uma API RESTful desenvolvida com **Spring Boot 3** e **JPA/Hibernate**, é um pequeno sistema de pedidos. Utiliza de conceitos de construção de APIs REST com o ecossistema Spring.

## Tecnologias usadas

- Java 17+
- Spring Boot 3
- Spring Data JPA
- H2 Database (perfil de testes)
- Maven

## O que tem aqui?

- CRUD completo de **Usuários**, **Pedidos**, **Produtos** e **Categorias**
- Relacionamentos entre entidades (OneToMany, ManyToOne, ManyToMany)
- Controle de exceções global
- Injeção de dependências e boas práticas de estrutura
- Perfil de ambiente (`application-dev.properties` e `application-test.properties`)

## Como rodar o projeto

1. **Pré-requisitos:**
   - Java 17 ou superior
   - Maven instalado

2. **Clone o repositório:**

   ```bash
   git clone git@github.com:carloseduardoscc/workshop-springboot3-jpa.git
3. **Entre na pasta do projeto:**

   ```bash
   cd workshop-springboot3-jpa

4. **Execute o projeto:**

   ```bash
   ./mvnw spring-boot:run
Ou no Windows:


    mvnw.cmd spring-boot:run

5. **Acesse a aplicação:**

A API estará disponível em: http://localhost:8080

## 🛤️ Endpoints principais

- Recurso	Método	Endpoint	Descrição
- Usuários	GET	/users	Lista todos os usuários
- Usuários	GET	/users/{id}	Busca usuário por ID
- Pedidos	GET	/orders	Lista todos os pedidos
- Produtos	GET	/products	Lista todos os produtos
- Categorias	GET	/categories	Lista todas as categorias
  
## 🧰 Estrutura do Projeto
```matlab
src
├── main
│   ├── java
│   │   └── com.springproject.course
│   │       ├── entities
│   │       ├── repositories
│   │       ├── resources
│   │       ├── services
│   │       └── config
│   └── resources
│       ├── application.properties
│       ├── application-dev.properties
│       └── application-test.properties
└── test
