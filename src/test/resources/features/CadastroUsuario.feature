# language: pt
Funcionalidade: Cadastro de novo usuário
  Como usuário do sistema
  Quero cadastrar um novo usuário
  Para que ele tenha acesso ao sistema

  Cenário: Cadastro bem-sucedido de usuário
    Dado que eu tenha os seguintes dados do usuário:
      | campo       | valor         |
      | nome        | João Silva    |
      | email       | joao@teste.com|
      | senha       | senha123      |
    Quando eu enviar uma requisição POST para o endpoint "/api/usuarios"
    Então o status code da resposta deve ser 200
    E o corpo da resposta deve conter a mensagem "Usuário criado com sucesso com ID:"

  Cenário: Falha no cadastro de usuário com dados inválidos
    Dado que eu tenha os seguintes dados inválidos do usuário:
      | campo       | valor     |
      | nome        |           |
      | email       |           |
    Quando eu enviar uma requisição POST para o endpoint "/api/usuarios"
    Então o status code da resposta deve ser 400
    E o corpo da resposta deve conter a mensagem de erro
