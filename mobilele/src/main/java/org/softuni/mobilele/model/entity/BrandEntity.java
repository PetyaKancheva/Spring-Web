package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import org.softuni.mobilele.model.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "brands")
public class BrandEntity extends BaseEntity {
    @Column(unique=true,nullable=false)
    private String name;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private List<ModelEntity> models;

    public BrandEntity (){
            models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public BrandEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public BrandEntity setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }
}
