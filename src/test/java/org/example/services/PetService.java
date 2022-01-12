package org.example.services;

import io.restassured.response.Response;
import org.example.models.requests.PetRequest;
import org.example.models.responses.ApiResponse;
import org.example.models.responses.CreatePetResponse;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class PetService extends RestService {
    public CreatePetResponse createPet(PetRequest petRequest) {
        Response response = (Response) given()
                .spec(REQ_SPEC)
                .body(petRequest)
                .post();

        return setResponse(response, CreatePetResponse.class);
    }



    @Override
    public String getBasePath() {
        return "/pet";
    }
}
