package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import services.CadastroUsuarioService;
import io.cucumber.java.pt.Então;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;


public class CadastroUsuarioSteps {


    CadastroUsuarioService cadastroUsuarioService = new CadastroUsuarioService();
    

    @Dado("que eu tenha os seguintes dados do usuário:")
    public void que_eu_tenha_os_seguintes_dados_do_usuario(List<Map<String, String>> rows) {
    	for(Map<String, String> columns : rows) {
    		cadastroUsuarioService.setFieldsUser(columns.get("campo"),  columns.get("valor"));
        }
    }
    
    @Dado("que eu tenha os seguintes dados inválidos do usuário:")
    public void que_eu_tenha_os_seguintes_dados_invalidos_do_usuario(List<Map<String, String>> rows) {
    	for(Map<String, String> columns : rows) {
    		cadastroUsuarioService.setFieldsUser(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Quando("eu enviar uma requisição POST para o endpoint {string}")
    public void eu_enviar_uma_requisição_post_para_o_endpoint(String endPoint) {
    	cadastroUsuarioService.createDelivery(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void o_status_code_da_resposta_deve_ser(int statusCode) {
        assertEquals(statusCode, cadastroUsuarioService.response.statusCode());
    }

    @Então("o corpo da resposta deve conter a mensagem {string}")
    public void o_corpo_da_resposta_deve_conter_a_mensagem(String mensagem) {
        assertTrue(cadastroUsuarioService.response.getBody().asString().contains(mensagem));
    }

    @Então("o corpo da resposta deve conter a mensagem de erro")
    public void o_corpo_da_resposta_deve_conter_a_mensagem_de_erro() {
    	String mensagemErro = "Erro no cadastro do usuário";
        String responseBody = cadastroUsuarioService.response.getBody().asString();
        assertTrue(responseBody.contains(mensagemErro), "A mensagem de erro esperada não foi encontrada no corpo da resposta.");
    }
}
