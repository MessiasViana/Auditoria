# language: pt
Funcionalidade: Atualizar Auditoria e verificar contrato
  Como usuário da API
  Quero atualizar uma auditoria pelo ID
  Para que eu possa modificar as informações de auditorias no sistema

  Cenário: Atualizar auditoria com sucesso
    Dado que exista uma auditoria cadastrada com ID 24
      | campo    | valor                  |
      | descricao| Auditoria atualizada   |
      | dataAgendada| 2024-06-01T10:00:00   |
    Quando eu enviar uma requisição PUT para o endpoint "/api/auditorias/24" com os dados da auditoria
    Então o status code da resposta ao atualizar deve ser 200
    E que o arquivo de contrato atualizar auditoria esperado é o "Atualizar Auditoria Sucesso"
    Então a resposta da requisição atualizar auditoria deve estar em conformidade com o contrato selecionado
