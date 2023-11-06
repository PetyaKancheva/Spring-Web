package org.softuni.mobilele.model.dto;

public class ModelDTO {
    private Long id;
    private String name;
    private Integer startYear;
    private Integer endYear;
    private String imageUrl;


    public ModelDTO() {

    }

    public ModelDTO(Long id, String name, Integer startYear, Integer endYear, String imageUrl) {
        this.id = id;
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public ModelDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelDTO setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelDTO setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
