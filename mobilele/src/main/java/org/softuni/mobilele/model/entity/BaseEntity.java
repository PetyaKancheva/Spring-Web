package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;

@MappedSuperclass
public  abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

}
