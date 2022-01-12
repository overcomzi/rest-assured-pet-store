package org.example.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.models.responses.ApiResponse;

public abstract class RestService {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    public abstract String getBasePath();

    protected RequestSpecification REQ_SPEC;

    public RestService() {
        REQ_SPEC = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .setContentType(ContentType.JSON)
                .build();
    }

    public <T extends ApiResponse> T setResponse(Response response, Class<T> tClass) {
        T petResponse = response.as(tClass);
        petResponse.setResponse(response);
        return petResponse;
    }


}
