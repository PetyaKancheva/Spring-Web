package org.softuni.mobilele.model.dto;

public class ModelDTO{
    private Long id;
    private String name;


    public ModelDTO(Long id, String name, Integer startYear, Integer endYear, String imageUrl) {
        this.id = id;
        this.name = name;

    }

    public ModelDTO() {

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

    public void setId(Long id) {
        this.id = id;
    }

}
