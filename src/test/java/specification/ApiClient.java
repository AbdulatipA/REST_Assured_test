package specification;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {
    private RequestState requestState;

    public ApiClient() {
        this.requestState = new GuestState();
    }

    //сменя состояния
    public void changesState(RequestState newState) {
        this.requestState = newState;
    }


    public RequestSpecification request() {
        return given().spec(requestState.getRequestSpecification());
    }
}
