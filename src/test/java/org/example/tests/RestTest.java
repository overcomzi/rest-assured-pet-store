package org.example.tests;

import org.apache.http.HttpStatus;
import org.example.RestWrapper;
import org.example.models.requests.PetRequest;
import org.example.models.responses.CreatePetResponse;
import org.example.tests.asserts.PetAsserts;
import org.example.utils.PetGenerator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RestTest {
    private static RestWrapper api;

    @BeforeSuite
    public static void prepareClient() {
        api = RestWrapper.prepare();
    }

    @Test(description = "Создание питомца со свеми полями")
    public void createFullValidPet() {
        PetRequest petRequest = PetGenerator.getRandomFullPet();
        CreatePetResponse petResponse = api.getPetService()
                .createPet(petRequest);

        System.out.println(petRequest);
        System.out.println(petResponse);

        assertThat(petResponse)
                .extracting(CreatePetResponse::getStatusCode)
                .isEqualTo(HttpStatus.SC_OK);

        assertThat(petResponse)
                .extracting(response -> (int)response.getTime().toMillis())
                .matches((mills) -> mills <= 10_000);

        assertThat(petResponse)
                .usingRecursiveComparison()
                .ignoringFields("response")
                .isEqualTo(petRequest);
    }

    @Test(description = "Создание питомца только с обязательными полями")
    public void createRequiredPetField() {
        PetRequest petRequest = PetGenerator.getRequiredFieldPet();
        CreatePetResponse petResponse = api.getPetService()
                .createPet(petRequest);

        assertThat(petResponse)
                .extracting(CreatePetResponse::getStatusCode)
                .isEqualTo(HttpStatus.SC_OK);

        assertThat(petResponse)
                .extracting(response -> (int)response.getTime().toMillis())
                .matches((mills) -> mills <= 10_000);

        assertThat(petResponse)
                .usingRecursiveComparison()
                .ignoringFields("response")
                .isEqualTo(petRequest);
    }

    @Test(description = "Создание питомца с отсутствующими обязательными параметрами")
    public void createRequiredNotAllPetField() {
        PetRequest petRequest = PetGenerator.getRequiredNotAllFieldPet();
        CreatePetResponse petResponse = api.getPetService()
                .createPet(petRequest);

        assertThat(petResponse)
                .extracting(CreatePetResponse::getStatusCode)
                .isEqualTo(HttpStatus.SC_BAD_REQUEST);

        assertThat(petResponse)
                .extracting(response -> (int)response.getTime().toMillis())
                .matches((mills) -> mills <= 10_000);

        assertThat(petResponse)
                .usingRecursiveComparison()
                .ignoringFields("response")
                .isEqualTo(petRequest);
    }

    @Test(description = "Создание питомца с пустым body")
    public void createEmptyPet() {
        PetRequest petRequest = PetGenerator.getEmptyPet();
        CreatePetResponse petResponse = api.getPetService()
                .createPet(petRequest);

        PetAsserts.createdPet(petResponse)
                .assertCreateEmptyPet();
    }

    @Test(description = "Выполнение запроса создания одного и того же питомца 2 раза")
    public void createPetRepeat() {
        PetRequest petRequest = PetGenerator.getRequiredFieldPet();
        CreatePetResponse petResponse1 = api.getPetService()
                .createPet(petRequest);

        CreatePetResponse petResponse2 = api.getPetService()
                .createPet(petRequest);

        assertThat(petRequest)
                .usingRecursiveComparison()
                .ignoringFields("response")
                .isEqualTo(petResponse2);
    }
}
