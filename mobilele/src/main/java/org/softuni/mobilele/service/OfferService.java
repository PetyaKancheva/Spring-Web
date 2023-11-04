package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailsDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.UUID;

public interface OfferService {

    UUID addOffer(CreateOfferDTO createOfferDTO);
    Page<OfferDetailsDTO> getAllOffers(Pageable pageable);

}
