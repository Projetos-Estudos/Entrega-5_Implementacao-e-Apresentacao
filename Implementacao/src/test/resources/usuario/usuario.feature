# language: pt

Funcionalidade: Teste da Classe Usuario

  Cenário: Definir e obter o código do usuário
    Dado um objeto Usuario
    Quando eu defino o código do usuário como 1
    Então o código do usuário deve ser 1

  Cenário: Definir e obter o nome de acesso do usuário
    Dado um objeto Usuario
    Quando eu defino o nome de acesso do usuário como "usuario123"
    Então o nome de acesso do usuário deve ser "usuario123"

  Cenário: Definir e obter a senha do usuário
    Dado um objeto Usuario
    Quando eu defino a senha do usuário como "senha123"
    Então a senha do usuário deve ser "senha123"