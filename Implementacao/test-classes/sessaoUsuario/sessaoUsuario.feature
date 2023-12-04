# language: pt

Funcionalidade: Controle de Sessão do Usuário

  Cenário: Iniciar uma sessão para o usuário
    Dado que o usuário não tem uma sessão ativa
    Quando o usuário inicia uma sessão com o código do usuário 123
    Então a sessão do usuário deve ser iniciada
    E o código do usuário na sessão deve ser 123

  Cenário: Encerrar a sessão do usuário
    Dado que o usuário tem uma sessão ativa
    Quando o usuário encerra a sessão
    Então a sessão do usuário deve ser encerrada
    E o código do usuário na sessão deve ser 0

