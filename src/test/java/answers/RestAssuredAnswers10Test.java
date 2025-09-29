package answers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAnswers10Test {

    @Test
    public void testArgentinaPopulation() {
        // Simuleer een REST endpoint dat de query select * from HR.COUNTRIES uitvoert
        // In werkelijkheid kun je dit vervangen door jouw eigen endpoint die PL/SQL queries uitvoert
        Response response = RestAssured.given()
                .baseUri("https://example.com/livesql")  // vervang door eigen endpoint
                .contentType("application/json")
                .body("{ \"query\": \"SELECT * FROM HR.COUNTRIES\" }")
                .post("/executeQuery");

        // Check dat de call succesvol is
        assertThat(response.getStatusCode(), equalTo(200));

        // Parse JSON en zoek de record voor 'Argentina'
        String countryName = response.jsonPath().getString("items.find { it.country_name == 'Argentina' }.country_name");
        int lastColumnValue = response.jsonPath().getInt("items.find { it.country_name == 'Argentina' }.region_id"); // laatste kolom = region_id

        // Asserties
        assertThat(countryName, equalTo("Argentina"));
        assertThat(lastColumnValue, equalTo(20));
    }
}
