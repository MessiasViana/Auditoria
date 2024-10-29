# language: pt
Funcionalidade: Atualizar dados de usuário
  Como usuário do sistema
  Quero atualizar as informações de um usuário específico
  Para corrigir ou atualizar seus dados

  Cenário: Atualização bem-sucedida de usuário
    Dado que exista um usuário com ID 1
      | campo  | valor         |
      | nome   | Ana Costa     |
      | email  | ana@teste.com |
    Quando eu enviar uma requisição PUT para o endpoint "/api/usuarios/1" com esses dados
    Então o status code da resposta deve ser 200
    E o corpo da resposta deve conter as informações atualizadas do usuário

  Cenário: Tentativa de atualizar usuário não encontrado
    Dado que não exista um usuário com ID 999
      | campo  | valor          |
      | nome   | Carlos Nunes   |
      | email  | carlos@teste.com |
    Quando eu enviar uma requisição PUT para o endpoint "/api/usuarios/999"
    Então o status code da resposta deve ser 404
    E o corpo da resposta deve conter a mensagem "Usuário não encontrado com ID: 999"
