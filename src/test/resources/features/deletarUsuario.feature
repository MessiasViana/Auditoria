# language: pt
Funcionalidade: Deletar usuário
  Como usuário do sistema
  Quero deletar um usuário específico
  Para remover seu acesso ao sistema

  Cenário: Deletar usuário com sucesso
    Dado que exista um usuário com ID 1
    Quando eu enviar uma requisição DELETE para o endpoint "/api/usuarios/1"
    Então o status code da resposta deve ser 200
    E o corpo da resposta deve conter a mensagem "Usuário removido com sucesso com ID: 1"

  Cenário: Tentativa de deletar um usuário não encontrado
    Dado que não exista um usuário com ID 999
    Quando eu enviar uma requisição DELETE para o endpoint "/api/usuarios/999"
    Então o status code da resposta deve ser 404
    E o corpo da resposta deve conter a mensagem "Usuário não encontrado com ID: 999"
