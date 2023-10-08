package org.softuni.mobilele.model;

import jakarta.persistence.*;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;

import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private EngineType engine;
    @Column(name="image_url",columnDefinition = "TEXT")
    private String imageUrl;
    @Column
    private Integer mileage;
    @Column
    private Double price;
    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;
    @Column
    private Integer year;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;
    @OneToOne
    @JoinColumn(name="model_id")
    private ModelEntity model;


    @ManyToOne
    @JoinColumn(name="seller_id")
    private UserEntity seller;

    public OfferEntity(){
            }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }
}
