package org.example.utils;

import com.github.javafaker.Faker;
import org.example.models.parts.Category;
import org.example.models.parts.Status;
import org.example.models.parts.Tag;
import org.example.models.requests.PetRequest;

import java.util.List;
import java.util.Random;

import static org.example.utils.FakeGenerator.getPositive;

public class PetGenerator {
    private static Faker faker = new Faker();

    public static PetRequest getRequiredFieldPet() {
        return PetRequest.builder()
                .withName(getPetName())
                .withId(getRandomPetId())
                .withPhotoUrls(
                        getPhotoUrls()
                )
                .withTags(
                        getPetTags()
                )
                .build();
    }

    private static List<Tag> getPetTags() {
        return List.of(
                new Tag(566, "dog"),
                new Tag(677, "cute")
        );
    }

    public static String getPetName() {
        return "Maxim";
    }

    public static List<String> getPhotoUrls() {
        return List.of(
                "https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg",
                "https://res.cloudinary.com/dk-find-out/image/upload/q_80,w_1920,f_auto/580540_mjznrj.jpg"
        );
    }

    public static PetRequest getRandomFullPet() {
        return PetRequest.builder()
                .withName(getRandomPetName())
                .withId(getRandomPetId())
                .withCategory(
                        getRandomPetCategory()
                ).withPhotoUrls(getRandomPetPhotoUrls())
                .withStatus(getRandomPetStatus())
                .withTags(getRandomPetTags())
                .build();
    }

    public static Category getRandomPetCategory() {
        return new Category(getRandomPetCategoryId(), faker.lorem().word());
    }

    public static long getRandomPetId() {
        return getPositive();
    }

    public static long getRandomPetCategoryId() {
        return getPositive();
    }

    public static List<String> getRandomPetPhotoUrls() {
        return List.of(
                faker.internet().avatar(),
                faker.internet().avatar()
        );
    }

    public static String getRandomPetStatus() {
        return faker.options().option(Status.class).name().toLowerCase();
    }

    public static Tag getRandomPetTag() {
        return new Tag(getPositive(), faker.pokemon().name());
    }

    public static List<Tag> getRandomPetTags() {
        return List.of(
                getRandomPetTag(),
                getRandomPetTag()
        );
    }

    public static String getRandomPetName() {
        return faker.funnyName().name();
    }

    public static PetRequest getRequiredNotAllFieldPet() {
        return PetRequest.builder()
                .withName(getPetName())
                .withId(getRandomPetId())
                .withPhotoUrls(
                        getPhotoUrls()
                )
                .build();
    }

    public static PetRequest getEmptyPet() {
        return PetRequest.builder().build();
    }
}
