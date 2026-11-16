Feature: Validar Lista de Usuario pelo ID

  Scenario: Validar lista de usuario pelo _id
  Given que o usuario deseja validar a lista de usuarios pelo _id"
    When ele envia uma requisicao GET para o endpoint_id "/usuarios?_id=113E0uRip0RjnvAS"
    Then ele deve receber uma resposta com status code 200 com a lista de usuarios
       
