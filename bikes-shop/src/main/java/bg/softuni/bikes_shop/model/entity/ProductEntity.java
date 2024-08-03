package bg.softuni.bikes_shop.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity extends BaseEntity{
    @Column(name="name" ,nullable = false)
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="picture_URL")
    private String pictureURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
