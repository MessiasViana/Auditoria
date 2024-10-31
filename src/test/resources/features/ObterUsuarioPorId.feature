# language: pt
Funcionalidade: Obter usuário por ID
  Como usuário da API
  Quero obter os dados de um usuário pelo seu ID
  Para que eu possa visualizar as informações do usuário

  Cenário: Usuário encontrado pelo ID
    Dado que exista um usuário cadastrado com ID 21
    Quando eu enviar uma requisição GET para o endpoint "/api/usuarios/21"
    Então o status code da da busca por id sucesso deve ser 200


  Cenário: Usuário não encontrado pelo ID
    Quando eu enviar uma requisição GET para o endpoint "/api/usuarios/999"
    Então o status code da falha da busca por id deve ser 404
    E o corpo de resposta de erro da api de busca por id deve retornar "Usuário não encontrado."

