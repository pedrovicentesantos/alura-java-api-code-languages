# Repositório

O repositório contém o desenvolvimento de uma API que gerencia linguagens de programação utilizando Spring Boot e Java, feita como parte da Imersão Java da [Alura](https://www.alura.com.br).

Os dados estão salvos em banco de dados MongoDB hospedado no [MongoDB Cloud](https://cloud.mongodb.com).

O deploy da aplicação foi feito no [Railway](https://railway.app) e a url base para acessá-la é:

[https://alura-java-api-code-languages-production.up.railway.app](https://alura-java-api-code-languages-production.up.railway.app)

## Endpoints

- GET /languages:
  - Retorna todas as linguagens salvas sendo possível ordenar por "ranking" ou "stars"
- POST /languages:
  - Cria uma nova linguagem
- DELETE /languages/{id}:
  - Deleta uma linguagem
- PATCH /languages/{id}:
  - Altera o nome ou imagem de uma linguagem
- PATCH /languages/add-star/{id}:
  - Adiciona uma estrela a linguagem

## Rodando a aplicação

Para rodar a aplicação é necessário ter o JDK 17 instalado e alterar o arquivo .env.example para os valores apropriados.
Feito isto, a aplicação estará disponível na url base: [http://localhost:8080](http://localhost:8080).
