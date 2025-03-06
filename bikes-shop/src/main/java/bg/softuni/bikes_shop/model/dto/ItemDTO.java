package bg.softuni.bikes_shop.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class ItemDTO{
    @NotEmpty
    Long productID;
    @NotEmpty
    String productName;
    @NotEmpty
    Double price;
    @NotEmpty
    Integer quantity;

//
//    public static ItemDTO empty(){
//        return new ItemDTO(null,null,null,null);
//    }
//


    public ItemDTO() {
    }

    public @NotEmpty Long getProductID() {
        return productID;
    }

    public void setProductID(@NotEmpty Long productID) {
        this.productID = productID;
    }

    public @NotEmpty String getProductName() {
        return productName;
    }

    public void setProductName(@NotEmpty String productName) {
        this.productName = productName;
    }

    public @NotEmpty Double getPrice() {
        return price;
    }

    public void setPrice(@NotEmpty Double price) {
        this.price = price;
    }

    public @NotEmpty Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotEmpty Integer quantity) {
        this.quantity = quantity;
    }
}
