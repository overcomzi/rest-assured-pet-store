package org.example.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import org.example.models.parts.Category;
import org.example.models.parts.Tag;

import java.time.Duration;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePetResponse extends ApiResponse{
    private String name;
    private long id;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;


    public CreatePetResponse() {}

    public CreatePetResponse(String name, long id, Category category, List<String> photoUrls, List<Tag> tags, String status) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static CreatePetResponse.Builder builder() {
        return CreatePetResponse.Builder.createBuilder();
    }

    public static final class Builder {
        private CreatePetResponse petRequest;

        private Builder() {
            petRequest = new CreatePetResponse();
        }

        private static CreatePetResponse.Builder createBuilder() {
            return new CreatePetResponse.Builder();
        }

        public CreatePetResponse.Builder withName(String name) {
            petRequest.setName(name);
            return this;
        }

        public CreatePetResponse.Builder withId(long id) {
            petRequest.setId(id);
            return this;
        }

        public CreatePetResponse.Builder withCategory(Category category) {
            petRequest.setCategory(category);
            return this;
        }

        public CreatePetResponse.Builder withPhotoUrls(List<String> photoUrls) {
            petRequest.setPhotoUrls(photoUrls);
            return this;
        }

        public CreatePetResponse.Builder withTags(List<Tag> tags) {
            petRequest.setTags(tags);
            return this;
        }

        public CreatePetResponse.Builder withStatus(String status) {
            petRequest.setStatus(status);
            return this;
        }

        public CreatePetResponse build() {
            return petRequest;
        }
    }

    @Override
    public String toString() {
        return "CreatePetResponse{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", category=" + category +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
