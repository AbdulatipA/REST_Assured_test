import io.restassured.specification.RequestSpecification;

public interface RequestState {
    RequestSpecification getRequestSpecification();
}
