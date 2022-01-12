package org.example.tests.asserts;

import org.example.config.PathConfig;
import org.example.models.responses.CreatePetResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.collection.IsMapContaining.hasKey;

public class PetAsserts {
    private  CreatePetResponse petResponse;

    private PetAsserts(CreatePetResponse petResponse) {
        this.petResponse = petResponse;
    }

    public static PetAsserts createdPet(CreatePetResponse petResponse) {
        return new PetAsserts(petResponse);
    }

    public PetAsserts assertCreateEmptyPet() {
        petResponse.getResponse()
                .then()
                .body(matchesJsonSchemaInClasspath(
                        PathConfig.getSchemaPath("response/create-pet-empty.json")
                ));

        return this;
    }
}
