package specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AdminState implements RequestState{
    @Override
    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(Links.BASELINK)
                .setContentType(ContentType.JSON)
                .addHeader("X-App-Token", "secret-token-123")
                .build();
    }
}
