package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.CategoryType;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {

    }

    public CategoryType getName() {
        return name;
    }

    public Category setName(CategoryType name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
