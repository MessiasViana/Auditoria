# language: pt
Funcionalidade: Atualizar Auditoria
  Como usuário da API
  Quero atualizar uma auditoria pelo ID
  Para que eu possa modificar as informações de auditorias no sistema

  Cenário: Atualizar auditoria com sucesso
    Dado que exista uma auditoria cadastrada com ID 24
      | campo    | valor                  |
      | dataAgendada| 2024-06-01T10:00:00   |
    Quando eu enviar uma requisição PUT para o endpoint "/api/auditorias/24" com os dados da auditoria
    Então o status code da resposta ao atualizar deve ser 200

  Cenário: Atualizar auditoria que não existe
    Dado que nao exista uma auditoria cadastrada com ID 999
    Quando eu enviar uma requisição PUT para o endpoint "/api/auditorias/999" com os dados da auditoria
    Então o status code da resposta ao dar erro deve ser 404
    E o corpo de resposta de erro da api de atualizacao deve retornar "Auditoria não encontrada."
