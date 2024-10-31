package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroUsuarioService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CadastroUsuarioSteps {
    CadastroUsuarioService cadastroUsuarioService = new CadastroUsuarioService();

    @Dado("que eu tenha os seguintes dados do usuário:")
    public void queEuTenhaOsSeguintesDadosDoUsuario(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            String campo = columns.get("campo");
            String valor = columns.get("valor");

            // Gerar um email aleatório se o campo for "email"
            if ("email".equals(campo)) {
                valor = "usuario_" + UUID.randomUUID().toString() + "@exemplo.com";
            }

            cadastroUsuarioService.setFieldsDelivery(campo, valor);
        }
    }


    @Dado("que já exista um usuário cadastrado com o email:")
    public void queJaExistaUmUsuarioCadastradoComOEmail(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroUsuarioService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }

        cadastroUsuarioService.createDelivery("/api/usuarios");
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de usuários")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeUsuarios(String endPoint) {
        cadastroUsuarioService.createDelivery(endPoint);
    }

    @Entao("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(Integer expectedStatusCode) {
        int actualStatusCode = cadastroUsuarioService.response.getStatusCode();
        Assert.assertEquals(expectedStatusCode.intValue(), actualStatusCode);
    }

    @Entao("o status code da resposta do erro deve ser {int}")
    public void oStatusCodeDaRespostaDoErroDeveSer(Integer expectedStatusCode) {
        int actualStatusCode = cadastroUsuarioService.response.getStatusCode();
        Assert.assertEquals(expectedStatusCode.intValue(), actualStatusCode);
    }

    @E("o corpo de resposta de erro da api de cadastro deve retornar {string}")
    public void oCorpoDeRespostaDeErroDaApiDeCadastroDeveRetornar(String message) {
        ErrorMessageModel errorMessageModel = cadastroUsuarioService.gson.fromJson(
                cadastroUsuarioService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }
}
