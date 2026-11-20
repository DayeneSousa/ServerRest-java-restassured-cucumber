Feature: Validar Lista de Usuario pelo ID

  Scenario Outline: Validar lista de usuario pelo _id e nome
    Given que o usuario deseja validar a lista de usuarios pelo _id e nome
    When ele envia uma requisicao GET para o endpoint "<endpoint>" com id "<id>" e nome "<nome>"
    Then ele deve receber uma resposta com status code <statusCode> com a lista de usuarios

    Examples:
      | endpoint  | id     | nome       | statusCode |
      | /usuarios |      |   fulano    | 200        |
