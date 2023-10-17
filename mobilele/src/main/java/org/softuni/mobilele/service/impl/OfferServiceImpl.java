package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.OfferAdditionDTO;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public void addOffer(OfferAdditionDTO offerAdditionDTO) {

    }

    @Override
    public void allOffers() {
        offerRepository.findAll();


    }
}
