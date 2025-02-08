# Sistema de Cadastro de Funcionários 

> Este é um sistema de gerenciamento de cadastro de funcionários desenvolvido com **Java** utilizando o **Spring Boot**, com persistência de dados em **PostgreSQL**. Ele permite o cadastro, consultas, atualização e exclusão de funcionários, bem como o gerenciamento de salários e funções.

## Funcionalidades
- **Cadastro de Funcionários:**
     - Permite cadastrar funcionários com dados como nome, data de nascimento, função e salário.
- **Remoção de funcionários:** 
     - Permite remover um funcionário específico.
- **Listagem de Funcionários:**
     - Exibe todos os funcionários cadastrados, ordenados por nome e com formatação de data e salário no padrão brasileiro.
- **Atualização de Salário:** 
     - Permite aumentar o salário de todos os funcionários.
- **Agrupamento por função:**
     - É possível obter uma lista de funcionários dividida por funções.
- **Aniversariantes do mês:**
     - É possível obter uma lista de aniversariantes de um ou mais meses específico(s).
- **Funcionário de maior idade:**
     - É possível obter a informação do funcionário mais experiente da empresa. 🎉
- **Total de salários:** 
     - É possível visualizar o total de salários.
- **Salários mínimos por funcionário:**
     - Visando o maior detalhamento de informações, é possível obter a quantidade de salários mínimos recebidos por cada funcionário.

## Tecnologias Utilizadas
![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=flat&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=flat&logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-8D704A?style=flat&logo=hibernate&logoColor=white)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-6DB33F?style=flat&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-1C3A3E?style=flat&logo=java&logoColor=white)

## Arquitetura da Aplicação
A aplicação segue uma arquitetura simples de MVC *(Model-View-Controller)*:

```
src
│
├── main
│   ├── java
│   │   └── registration_system
│   │       ├── controller
│   │       │   └── FuncionarioController.java  # Controlador
│   │       ├── dto
│   │       │   └── AniversarianteDoMêsDTO.java # DTO
│   │       │   └── FuncionarioDTO.java         # DTO
│   │       │   └── FuncionarioIdadeDTO.java    # DTO
│   │       │   └── FuncionarioSalarioDTO.java  # DTO
│   │       ├── model
│   │       │   └── FuncionarioModel.java      # Modelo (entidade)
│   │       │   └── PessoaModel.java           # Modelo 
│   │       ├── repository
│   │       │   └── FuncionarioRepository.java # Repositório (interface)
│   │       ├── service
│   │       │   └── FuncionarioService.java    # Serviço
│   │       ├──
│   │       └── Main.java                      # Classe principal
│   └── resources
│       ├── application.properties  # Configurações da aplicação
│       └── ...
│
└── pom.xml  # Dependências do projeto

```

## Como Executar a Aplicação

### Requisitos
- JDK 17
- Maven para gerenciamento de dependências e construção do projeto
- Banco de dados PostgreSQL

## Passos para rodar a aplicação:
- Navegue até o diretório onde deseja salvar o projeto:
`cd <seu-diretorio>`

- Clone o repositório:
`git clone https://github.com/Biiars00/sistema-cadastro-funcionarios.git`

- Execute o projeto com o Maven:
`mvn spring-boot:run`

   - Alternativamente, você pode empacotar o projeto como um arquivo JAR e executá-lo:
`java -jar target/sistema-cadastro-funcionarios.jar`

- A aplicação estará disponível na URL:
`http://localhost:8080`

## Endpoints da API

| Médoto   | URL                                      | Descrição |
| -------- | ---------------------------------------- | ----------- |
| POST     | /api-iniflex/cadastrar-funcionario       | Cadastrar funcionário |
| DELETE   | /api-iniflex/remover-funcionario/{id}    | Remover funcionário |
| GET      | /api-iniflex/listar-funcionarios         | Listar funcionário |
| PUT      | /api-iniflex/aumentar-salarios           | Aumentar salário |
| GET      | /api-iniflex/total-salarios              | Total de salários |
| GET      | /api-iniflex/quantidade-salarios-minimos | Quantidade de salários mínimos por funcionário |
| GET      | /api-iniflex/funcionario-maior-idade     | Funcionário com maior idade |
| GET      | /api-iniflex/aniversariantes-mes         | Aniversariantes do mês |
| GET      | /api-iniflex/funcionarios-funcao         | Agrupamento de funcionários por função |


