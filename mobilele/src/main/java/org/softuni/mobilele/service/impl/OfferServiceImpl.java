package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.CreateOfferDTO;;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.model.entity.OfferEntity;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.BrandRepository;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Service;
import java.sql.Types;


import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private CurrentUser currentUser;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, BrandRepository brandRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public UUID addOffer(CreateOfferDTO createOfferDTO) {
        OfferEntity newOffer = map(createOfferDTO);
        ModelEntity modelEntity = modelRepository.findById(createOfferDTO.modelId()).orElseThrow(() ->
                new IllegalArgumentException("Model with id " + createOfferDTO.modelId() + " not found!"));
        newOffer.setModel(modelEntity);
        UserEntity userEntity =userRepository.findByEmail(currentUser.getEmail()).orElseThrow(()-> new IllegalArgumentException( "No seller found!"));
        newOffer.setSeller(userEntity);

       offerRepository.save(newOffer);

        return newOffer.getUuid();
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
    private OfferEntity map(CreateOfferDTO createOfferDTO) {
        return new OfferEntity()
                .setUuid(UUID.randomUUID())
                .setEngine(createOfferDTO.engine())
                .setTransmission(createOfferDTO.transmission())
                .setDescription(createOfferDTO.description())
                .setMileage(createOfferDTO.mileage())
                .setImageUrl(createOfferDTO.imageURL())
                .setPrice(createOfferDTO.price())
                .setCreated(LocalDateTime.now())
                .setYear(createOfferDTO.year());
    }
}
