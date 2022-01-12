package org.example.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.models.parts.Category;
import org.example.models.parts.Tag;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetRequest {
    private String name;
    private long id;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;


    public PetRequest() {}

    public PetRequest(String name, int id, Category category) {
        this.name = name;
        this.id = id;
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

    public static Builder builder() {
        return Builder.createBuilder();
    }

    public static final class Builder {
        private PetRequest petRequest;

        private Builder() {
            petRequest = new PetRequest();
        }

        private static Builder createBuilder() {
            return new Builder();
        }

        public Builder withName(String name) {
            petRequest.setName(name);
            return this;
        }

        public Builder withId(long id) {
            petRequest.setId(id);
            return this;
        }

        public Builder withCategory(Category category) {
            petRequest.setCategory(category);
            return this;
        }

        public Builder withPhotoUrls(List<String> photoUrls) {
            petRequest.setPhotoUrls(photoUrls);
            return this;
        }

        public Builder withTags(List<Tag> tags) {
            petRequest.setTags(tags);
            return this;
        }

        public Builder withStatus(String status) {
            petRequest.setStatus(status);
            return this;
        }

        public PetRequest build() {
            return petRequest;
        }
    }

    @Override
    public String toString() {
        return "PetRequest{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", category=" + category +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
