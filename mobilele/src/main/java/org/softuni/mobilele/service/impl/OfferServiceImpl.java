package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.CreateOfferDTO;;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public UUID addOffer(CreateOfferDTO createOfferDTO) {
        return UUID.randomUUID();
    }

    @Override
    public void allOffers() {

    }

//    @Override
//    public List<OfferEntity> findAll() {
//        return null;
//    }


    //lic List<String> getModelAll(){
  //  offerRepository.findAll().stream().map(el.getModel().getName()-> .adde));
  //
  //
}
