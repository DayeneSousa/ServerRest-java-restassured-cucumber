package br.com.serverest.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ApiSteps {
    private String apiUrl;
    private Response response;

    @Dado("a API ServeRest")
    public void aApiServeRest() {
        apiUrl = System.getProperty("api.url", "https://serverest.dev");
    }

    @Quando("consulto os usuários")
    public void consultoOsUsuarios() {
        response = given().baseUri(apiUrl).when().get("/usuarios");
    }

    @Entao("recebo uma lista de usuários válida")
    public void receboUmaListaDeUsuariosValida() {
        response.then().statusCode(200).contentType("application/json");
        List<Map<String, Object>> usuarios = response.jsonPath().getList("usuarios");
        assertNotNull("usuarios deve ser uma lista", usuarios);
        Object quantidade = response.jsonPath().get("quantidade");
        assertTrue("quantidade deve ser um inteiro", quantidade instanceof Integer);
        assertEquals(usuarios.size(), quantidade);
        for (Map<String, Object> usuario : usuarios) {
            assertTrue(usuario.get("_id") instanceof String);
            assertTrue(usuario.get("nome") instanceof String);
            assertTrue(usuario.get("email") instanceof String);
            assertTrue("administrador deve ser true ou false",
                "true".equals(usuario.get("administrador")) || "false".equals(usuario.get("administrador")));
        }
    }
}
