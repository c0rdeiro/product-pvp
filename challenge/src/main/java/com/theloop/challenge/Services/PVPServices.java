package com.theloop.challenge.Services;

import com.theloop.challenge.Exceptions.ResourceNotFoundException;
import com.theloop.challenge.Models.PVP;
import com.theloop.challenge.Models.ProductRequest;
import com.theloop.challenge.Repositories.PVPRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PVPServices {

    private final PVPRepository pvpRepository;

    public PVPServices(PVPRepository pvpRepository) {
        this.pvpRepository = pvpRepository;
    }

    public PVP getProductPVP(ProductRequest productRequest) {
        List<PVP> results = pvpRepository.getPVPproductsByDate(productRequest.getProductId(), productRequest.getDate());

        if(results.isEmpty()){
            throw new ResourceNotFoundException("No pvp found for product found with id "
                    +productRequest.getProductId() + " in the date supplied");
        }

        return results.stream().max(Comparator.comparingInt(PVP::getPriority)).orElse(null);
    }
}
