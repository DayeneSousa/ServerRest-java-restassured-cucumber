# language: pt
@api
Funcionalidade: Consulta de usuários
  Cenário: Validar o payload da lista de usuários
    Dado a API ServeRest
    Quando consulto os usuários
    Então recebo uma lista de usuários válida
