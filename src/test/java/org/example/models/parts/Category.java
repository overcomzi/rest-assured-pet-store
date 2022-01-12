package org.example.models.parts;

public class Category {
    private long id;

    private String name;

    public Category() {
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return Builder.create();
    }

    public static final class Builder {
        private Category category;

        private Builder() {
            category = new Category();
        }

        private static Builder create() {
            return new Builder();
        }

        public Builder withId(long id) {
            category.setId(id);
            return this;
        }

        public Builder withName(String name) {
            category.setName(name);
            return this;
        }

        public Category build() {
            return category;
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
