package answers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class RestAssuredAnswers9Test {

    @BeforeEach
    public void setUp() {
        // Geen lokale baseURI meer, alles online
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // Reset voor flexibiliteit
    }

    @Test
    public void testGetSinglePostFromLiveApi() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("title", containsString("sunt aut facere")) // Minder streng dan equalTo
                .body("body", containsString("quia et suscipit")); // Valideer ook body
    }

    @Test
    public void testGetAllPostsFromLiveApi() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("", org.hamcrest.Matchers.hasSize(100));
    }

    @Test
    public void testPhpApiWith111() {
        given()
                .baseUri("https://softwaretestingbreak.com")
                .param("gas", 1)
                .param("brake", 1)
                .param("clutch", 1)
                .param("drive", "Drive")
                .when()
                .post("/testapplication-web.php")
                .then()
                .statusCode(200)
                .body(containsString("Hey nice! not a bug, but you found the API call!"))
                .body(containsString("quia et suscipit"));
    }
}
