import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Test {

    @org.junit.jupiter.api.Test
    public void testApiWithStateParent() {
        ApiClient apiClient = new ApiClient();

        apiClient.request()
                .when()
                    .get("/posts/1")
                .then()
                    .statusCode(200)
                    .body("id", equalTo(1))
                    .body("title", notNullValue());

        apiClient.changesState(new AdminState());

        String newPostJson =
                        """
                        {
                          "userId": 1,
                          "id": 1,
                          "title": "sunt",
                          "body": "quia"
                        }
                        """;

        apiClient.request()
                .contentType("application/json")
                .body(newPostJson)
                .when()
                    .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("sunt"))
                .body("body", equalTo("quia"));
    }
}
