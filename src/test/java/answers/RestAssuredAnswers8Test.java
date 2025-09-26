package answers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAnswers8Test {

    // Initializing the base URI for the live JSONPlaceholder API
    @Test
    public void testGetSinglePostFromLiveApi() {
        // Setting up the base URI for the live API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Performing a GET request to fetch a single post and validating the response
        given()
            .when()
                .get("/posts/1")
            .then()
                .statusCode(200)
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    // Validating the total number of posts from the live API
    @Test
    public void testGetAllPostsFromLiveApi() {
        // Setting up the base URI for the live API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Performing a GET request to fetch all posts and validating the response size
        given()
            .when()
                .get("/posts")
            .then()
                .statusCode(200)
                .body("", org.hamcrest.Matchers.hasSize(100));
    }
}