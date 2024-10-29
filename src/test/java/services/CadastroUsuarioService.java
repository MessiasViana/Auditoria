package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.UsuarioModel;
import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

public class CadastroUsuarioService {
	
    final UsuarioModel usuarioModel = new UsuarioModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    
    String baseUrl = "http://localhost:8080";
    
    
    public void setFieldsUser(String field, String value) {
        switch (field) {
            case "nome" -> usuarioModel.setNome(value);
            case "email" -> usuarioModel.setEmail(value);
            case "senha" -> usuarioModel.setSenha(value);
            case "dataDeCadastro" -> usuarioModel.setDataDeCadastro(LocalDateTime.parse(value));
            default -> throw new IllegalStateException("Unexpected field: " + field);
        }
    }
    
    public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(usuarioModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }
}