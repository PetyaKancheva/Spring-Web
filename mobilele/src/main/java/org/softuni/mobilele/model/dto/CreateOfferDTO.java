package org.softuni.mobilele.model.dto;

public record CreateOfferDTO(String model, Double price, String Engine, String transmission, Integer year, Integer Mileage, String description, String imageURL) {
}
