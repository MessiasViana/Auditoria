# language: pt
Funcionalidade: Cadastro de novo usuário
  Como usuário da API
  Quero cadastrar um novo usuário
  Para que o registro seja salvo corretamente no sistema

  Cenário: Cadastro bem-sucedido de usuário
    Dado que eu tenha os seguintes dados do usuário:
      | campo | valor                  |
      | nome  | TesteSucessoExemplo        |
      | email | TesteSucessoExemplo@exemplo.com |
      | senha | senha123               |
    Quando eu enviar a requisição para o endpoint "/api/usuarios" de cadastro de usuários
    Então o status code da resposta deve ser 200

  Cenário: Tentativa de cadastro com e-mail duplicado
    Dado que já exista um usuário cadastrado com o email:
      | campo | valor               |
      | nome  | João Silva          |
      | email | aleatorioaleatorio@email.com|
      | senha | senhaSegura123      |
    Quando eu enviar a requisição para o endpoint "/api/usuarios" de cadastro de usuários
    Então o status code da resposta do erro deve ser 400
    E o corpo de resposta de erro da api de cadastro deve retornar "Email já cadastrado."