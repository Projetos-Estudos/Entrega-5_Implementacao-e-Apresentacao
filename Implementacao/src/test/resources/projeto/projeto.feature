# language: pt
Funcionalidade: Projeto

    Cenário: Defindo codigo do projeto
        Dado um objeto Projeto
        Quando eu defino o código do projeto como 1
        Então o código do projeto deve ser 1

    Cenário: Defindo o nome do projeto
        Dado um objeto Projeto
        Quando eu defino o nome do projeto como "Meu Projeto"
        Então o nome do projeto deve ser "Meu Projeto"

    Cenário: Defindo a data de inclusão do projeto
        Dado um objeto Projeto
        Quando eu defino a data de inclusão do projeto como "2023-10-31T12:00:00"
        Então a data de inclusão do projeto deve ser "2023-10-31T12:00:00"

    Cenário: Defindo a data de início do projeto
        Dado um objeto Projeto
        Quando eu defino a data de início do projeto como "2023-10-31"
        Então a data de início do projeto deve ser "2023-10-31"

    Cenário: Defindo a data de previsão de término do projeto
        Dado um objeto Projeto
        Quando eu defino a data de previsão de término do projeto como "2023-11-30"
        Então a data de previsão de término do projeto deve ser "2023-11-30"

    Cenário: Defindo a data de término do projeto
        Dado um objeto Projeto
        Quando eu defino a data de término do projeto como "2023-11-15"
        Então a data de término do projeto deve ser "2023-11-15"

    Cenário: Defindo a descrição do projeto
        Dado um objeto Projeto
        Quando eu defino a descrição do projeto como "Descrição do Projeto"
        Então a descrição do projeto deve ser "Descrição do Projeto"


