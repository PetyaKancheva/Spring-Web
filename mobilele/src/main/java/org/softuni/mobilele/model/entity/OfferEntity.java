package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    @NotNull
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    @Column(name="image_url",columnDefinition = "TEXT")
    private String imageUrl;
    @Column
    private Integer mileage;
    @Column
    private Integer price;
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
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

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferEntity setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public OfferEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferEntity setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }
}
