package org.softuni.mobilele.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.softuni.mobilele.model.entity.BaseEntity;

import java.time.LocalDateTime;
@Entity
@Table(name= "brands")
public class BrandEntity extends BaseEntity {
    @Column(unique=true,nullable=false)
    private String name;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;

    public BrandEntity (){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
