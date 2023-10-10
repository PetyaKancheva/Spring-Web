package org.softuni.mobilele.model;

import jakarta.persistence.*;

@MappedSuperclass
public  abstract class BaseEntity {
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
