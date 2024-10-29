# language: pt
Funcionalidade: Obter usuário por ID
  Como usuário do sistema
  Quero buscar um usuário específico pelo ID
  Para visualizar suas informações detalhadas

  Cenário: Obter usuário com sucesso
    Dado que exista um usuário com ID 1
    Quando eu enviar uma requisição GET para o endpoint "/api/usuarios/1"
    Então o status code da resposta deve ser 200
    E o corpo da resposta deve conter as informações do usuário com ID 1

  Cenário: Usuário não encontrado
    Dado que não exista um usuário com ID 999
    Quando eu enviar uma requisição GET para o endpoint "/api/usuarios/999"
    Então o status code da resposta deve ser 404
    E o corpo da resposta deve conter a mensagem "Usuário não encontrado com ID: 999"
