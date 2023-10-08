package org.softuni.mobilele.model;

import jakarta.persistence.*;
import org.softuni.mobilele.model.enums.ModelCategory;


import java.time.LocalDateTime;

@Entity
@Table(name= "models")
public class ModelEntity extends BaseEntity {
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private ModelCategory category;
    //TODO check if it is correct
    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;
    @Column(name ="start_year")
    private Integer startYear;
    @Column(name= "end_year")
    private Integer endYear;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;
    @ManyToOne
    @JoinColumn(name="brand_id",nullable = false)
    private BrandEntity brand;

    public ModelEntity(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public void setCategory(ModelCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
