package Steps.usuario;

import config.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidarUsuarioIdStep {

    private Response response;
    private static final String url_base = TestConfig.getBaseUrl();

    @Given("que o usuario deseja validar a lista de usuarios pelo _id e nome")
    public void queOUsuarioDesejaValidarAListaDeUsuariosPelo_id() {
    }

    @When("ele envia uma requisicao GET para o endpoint {string} com id {string} e nome {string}")
    public void eleEnviaUmaRequisicaoGETParaOEndpointComIdENome(String endpoint, String id, String nome) {
        response = given()
                .queryParam("_id", id)
                .queryParam("nome", nome)
                .when()
                .get(url_base + endpoint)
                .then()
                .extract().response();

        System.out.println("Resposta da API: " + response.getBody().asPrettyString());
    }

    @Then("ele deve receber uma resposta com status code {int} com a lista de usuarios")
    public void eleDeveReceberUmaRespostaComStatusCodeComAListaDeUsuarios(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
        System.out.println("Status code recebido: " + response.getStatusCode());
    }

}