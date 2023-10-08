package org.softuni.mobilele.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    //TODO check if this is correct
    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

}
