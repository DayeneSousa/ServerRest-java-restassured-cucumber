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

    @Given("que o usuario deseja validar a lista de usuarios pelo _id\"")
    public void queOUsuarioDesejaValidarAListaDeUsuariosPelo_id() {
    }

    @When("ele envia uma requisicao GET para o endpoint_id {string}")
    public void eleEnviaUmaRequisicaoGETParaOEndpoint_id(String endpoint_id) {
        response = given()
                .when()
                .get(url_base + endpoint_id)
                .then()
                .extract().response();
    }

    @Then("ele deve receber uma resposta com status code {int} com a lista de usuarios")
    public void eleDeveReceberUmaRespostaComStatusCodeComAListaDeUsuarios(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

}