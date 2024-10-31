package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.*;
import model.ErrorMessageModel;
import org.json.JSONException;
import org.junit.Assert;
import services.ObterUsuariosPorIdService;

import java.io.IOException;
import java.util.Set;

public class ObterUsuarioPorIdSteps {
    ObterUsuariosPorIdService obterUsuarioService = new ObterUsuariosPorIdService();

    @Dado("que exista um usuário cadastrado com ID {int}")
    public void queExistaoUsuarioCadastradoComID(int id) {
    }

    @Quando("eu enviar uma requisição GET para o endpoint {string}")
    public void euEnviarUmaRequisicaoGETParaOEndpoint(String endPoint) {
        obterUsuarioService.createDelivery(endPoint);
    }

    @Entao("o status code da da busca por id sucesso deve ser {int}")
    public void oStatusCodeDaDaBuscaPorIdSucessoDeveSer(Integer expectedStatusCode) {
        int actualStatusCode = obterUsuarioService.response.getStatusCode();
        Assert.assertEquals(expectedStatusCode.intValue(), actualStatusCode);
    }


    @Então("o status code da falha da busca por id deve ser {int}")
    public void oStatusCodeDaFalhaDaBuscaPorIdDeveSer(Integer expectedStatusCode) {
        int actualStatusCode = obterUsuarioService.response.getStatusCode();
        Assert.assertEquals(expectedStatusCode.intValue(), actualStatusCode);
    }

    @E("o corpo de resposta de erro da api de busca por id deve retornar {string}")
    public void oCorpoDeRespostaDeErroDaApiDeBuscaPorIdDeveRetornar(String message) {
        ErrorMessageModel errorMessageModel = obterUsuarioService.gson.fromJson(
                obterUsuarioService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @E("que o arquivo de contrato obter usuario esperado é o {string}")
    public void queOArquivoDeContratoObterUsuarioEsperadoÉO(String contract) throws JSONException, IOException {
        obterUsuarioService.setContract(contract);
    }

    @Então("a resposta da requisição obter usuario deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoObterUsuarioDeveEstarEmConformidadeComOContratoSelecionado() throws JSONException, IOException {
        Set<ValidationMessage> validateResponse = obterUsuarioService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}
