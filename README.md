# artistas-spotify

INTELIPOST - #DESAFIO Backend Developer

artistas-spotify Desenvolvido com Java 11 e SpringWebFux

Run Terminal
** IMPORTANTE: Você deve instalar o Docker e o docker-compose ** JDK 11 ** Execute todos os comandos abaixo dentro do diretório raiz deste projeto
./docker-compose up

Build

./gradlew build

## Verificando se a aplicação subiu.

GET http://localhost:8081/musicas/v1/health

## Consultar todos os artitas na base de dados

GET http://localhost:8081/musicas/v1/artistas

## Consultar por artista

GET http://localhost:8081/musicas/v1/artista?nome=Xuxa

## Cadastrar um novo Artista na base

POST http://localhost:8081/musicas/v1/artista

    "nome": "Sidney Magal",
    "albuns": [
        "Baila Magal",
        "Coração Latino",
        "Vibrações"
    ]

## Alterar um artista

PUT http://localhost:8081/musicas/v1/artista/{uuid}

  
    "albuns": [
        "Baila Magal",
        "Coração Latino",
        "Vibrações",
        "Loucuras de Amor"
    ]

## Excluir um artista

DELETE http://localhost:8081/musicas/v1/artista/{uuid}


