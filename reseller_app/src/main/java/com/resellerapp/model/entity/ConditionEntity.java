package com.resellerapp.model.entity;


import com.resellerapp.model.ConditionEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="conditions")
public class ConditionEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ConditionEnum name ;
    private String description;

    public ConditionEnum getName() {
        return name;
    }

    public ConditionEntity setName(ConditionEnum name) {
        this.name = name;
        this.setDescription(name);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(ConditionEnum name) {
        String description = "";
        switch(name){
            case EXCELLENT :  description = "In perfect condition";
                break;
            case GOOD :  description = "Some signs of wear and tear or minor defects";
                break;
            case ACCEPTABLE :  description = "The item is fairly worn but continues to function properly";
                break;
        }
        return this.description=description;


    }
}
