package answers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class RestAssuredAnswers8Test {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://php-app:80"; // Docker service naam
    }

    @Test
    public void testGetSinglePostFromLiveApi() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void testGetAllPostsFromLiveApi() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("", org.hamcrest.Matchers.hasSize(100));
    }

    @Test
    public void testPhpApiWith111() {
        given()
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