# One Piece-inspired API RESTful

![One Piece Logo](https://th.bing.com/th/id/OIP.NAu8uNkA0fYkt25OB3qdlgAAAA?rs=1&pid=ImgDetMain)

Esta é uma API RESTful desenvolvida em Java 20 e Spring Boot 3, inspirada no mundo de One Piece. A aplicação utiliza um container Docker com a imagem do PostgreSQL como banco de dados. O versionamento de commits é feito utilizando Git Semântico para manter um histórico claro e compreensível.

## Funcionalidades Principais

### Estrutura do Projeto

O projeto segue a arquitetura de camadas com as seguintes estruturas:

1. **Repository**: Camada de acesso ao banco de dados.
2. **Service**: Lógica de negócios e regras de serviço.
3. **Controllers**: Responsável pela exposição da API e gerenciamento de requisições HTTP.

### Entidades

1. **Characters**: Representa os personagens do mundo de One Piece.
2. **Crew**: Representa as tripulações presentes no universo de One Piece.

### Dependências

- **Migrations com Flyway**: Gerenciamento de versão do banco de dados.
- **Swagger API**: Documentação interativa da API.
- **Model Mapper**: Facilita a conversão entre entidades e DTOs.
- **Jackson Dataformat**: Implementação de Content Negotiation, permitindo envio e recebimento de dados em YAML e XML.
- 
### Boas Práticas

- Utiliza Data Transfer Object (DTO) para a transferência eficiente de dados.

## Como Iniciar

1. Clone o repositório: `git clone https://github.com/Dim1trx/restapi-onepiece.git`
2. Acesse o diretório: `cd restapi-onepiece`
3. Execute a aplicação: `./mvnw spring-boot:run`

## TODO

- [ ] Adicionar HATEOAS para melhorar a navegação na API.
- [ ] Implementar testes unitários e de integração utilizando Mockito e RestAssured.
- [ ] Retornar informações paginadas para facilitar a consulta de grandes conjuntos de dados.

