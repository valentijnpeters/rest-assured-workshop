package answers;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAnswers10Test {

    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void setUp() {
        wireMockServer = new WireMockServer(8080); // Start on port 8080
        wireMockServer.start();

        // Configure the mock response
        wireMockServer.stubFor(post(urlEqualTo("/executeQuery"))
                .withRequestBody(containing("SELECT * FROM HR.COUNTRIES"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"items\": [{\"country_name\": \"Argentina\", \"region_id\": 20}]}")));
    }

    @AfterAll
    public static void tearDown() {
        wireMockServer.stop();
    }

    @Test
    public void testArgentinaPopulation() {
        // Point RestAssured to the mock server ( https://livesql.oracle.com/next/ )
        RestAssured.baseURI = "http://localhost:8080";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{ \"query\": \"SELECT * FROM HR.COUNTRIES\" }")
                .post("/executeQuery");

        // Check that the call is successful
        assertThat(response.getStatusCode(), equalTo(200));

        // Parse JSON and search for 'Argentina' record
        String countryName = response.jsonPath()
                .getString("items[0].country_name");
        int lastColumnValue = response.jsonPath().getInt("items[0].region_id");

        // Assertions
        assertThat(countryName, equalTo("Argentina"));
        assertThat(lastColumnValue, equalTo(20));
    }
}