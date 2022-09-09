package com.theloop.challenge.Controllers;

import com.theloop.challenge.Models.PVP;
import com.theloop.challenge.Models.ProductRequest;
import com.theloop.challenge.Services.PVPServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/pvp")
public class PVPController {

    private final PVPServices pvpServices;

    public PVPController(PVPServices pvpServices) {
        this.pvpServices = pvpServices;
    }

    @GetMapping()
    public PVP getProductPVP(@RequestBody ProductRequest productRequest){
        return pvpServices.getProductPVP(productRequest);
    }


}
