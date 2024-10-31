package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import org.json.JSONException;
import org.junit.Assert;
import services.AtualizarAuditoriaService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AtualizarAuditoriaSteps {

    AtualizarAuditoriaService atualizarAuditoriaService = new AtualizarAuditoriaService();

    @Dado("que exista uma auditoria cadastrada com ID {int}")
    public void queExistaUmaAuditoriaCadastradaComID(int arg0, List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            atualizarAuditoriaService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Dado("que nao exista uma auditoria cadastrada com ID {int}")
    public void queNaoExistaUmaAuditoriaCadastradaComID(int arg0) {
    }

    @Quando("eu enviar uma requisição PUT para o endpoint {string} com os dados da auditoria")
    public void euEnviarUmaRequisiçãoPUTParaOEndpointComOsDadosDaAuditoria(String endPoint) {
        atualizarAuditoriaService.createDelivery(endPoint);
    }

    @Então("o status code da resposta ao atualizar deve ser {int}")
    public void oStatusCodeDaRespostaAoAtualizarDeveSer(Integer  expectedStatusCode) {
        int actualStatusCode = atualizarAuditoriaService.response.getStatusCode();
        Assert.assertEquals(expectedStatusCode.intValue(), actualStatusCode);
    }


    @Então("o status code da resposta ao dar erro deve ser {int}")
    public void oStatusCodeDaRespostaAoDarErroDeveSer(Integer  expectedStatusCode) {
        int actualStatusCode = atualizarAuditoriaService.response.getStatusCode();
        Assert.assertEquals(expectedStatusCode.intValue(), actualStatusCode);
    }

    @E("o corpo de resposta de erro da api de atualizacao deve retornar {string}")
    public void oCorpoDeRespostaDeErroDaApiDeAtualizacaoDeveRetornar(String message) {
        ErrorMessageModel errorMessageModel = atualizarAuditoriaService.gson.fromJson(
                atualizarAuditoriaService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @E("que o arquivo de contrato atualizar auditoria esperado é o {string}")
    public void queOArquivoDeContratoAtualizarAuditoriaEsperadoÉO(String contract) throws JSONException, IOException {
        atualizarAuditoriaService.setContract(contract);
    }

    @Então("a resposta da requisição atualizar auditoria deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoAtualizarAuditoriaDeveEstarEmConformidadeComOContratoSelecionado() throws JSONException, IOException {
        Set<ValidationMessage> validateResponse = atualizarAuditoriaService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}