package specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GuestState implements RequestState{
    @Override
    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(Links.BASELINK)
                .setContentType(ContentType.JSON)
                .build();
    }
}
