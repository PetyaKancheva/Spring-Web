package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.OfferAdditionDTO;

public interface OfferService {
    //TODO create UUID offer
    void addOffer(OfferAdditionDTO offerAdditionDTO);
    void allOffers();

}
