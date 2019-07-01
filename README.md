# artistas-spotify

INTELIPOST - #DESAFIO Backend Developer

# Primeiros passos

O projeto possui um arquivo de Docker Compose. É necessário executar este arquivo antes de iniciar a execução do projeto.
run docker-compose up

## Verificando se a aplicação subiu.

GET http://localhost:8081/musicas/v1/health

## Consultar todos os artitas na base de dados

GET http://localhost:8081/musicas/v1/artistas

## Consultar por artista

http://localhost:8081/musicas/v1/artista?nome=Xuxa

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


