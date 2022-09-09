package com.theloop.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theloop.challenge.Controllers.PVPController;
import com.theloop.challenge.Enums.CurrencyEnum;
import com.theloop.challenge.Models.*;
import com.theloop.challenge.Repositories.PVPRepository;
import com.theloop.challenge.Services.PVPServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({PVPController.class, PVPServices.class})
public class PVPTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    PVPRepository pvpRepository;

    Brand BRAND_1 = new Brand(1, "Loja");
    Product PRODUCT_1 = new Product(35455, BRAND_1, "CPU");

    ListPrice LIST_PRICE_1 = new ListPrice(1, 30);
    ListPrice LIST_PRICE_2 = new ListPrice(1, 35);
    ListPrice LIST_PRICE_3 = new ListPrice(1, 37);
    ListPrice LIST_PRICE_4 = new ListPrice(1, 40);

    PVP PVP_1 = new PVP(1,
                        PRODUCT_1,
                        LIST_PRICE_1,
                        LocalDateTime.of(2020, 6, 14, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                        CurrencyEnum.EUR,
                 0);
    PVP PVP_2 = new PVP(2,
            PRODUCT_1,
            LIST_PRICE_2,
            LocalDateTime.of(2020, 6, 14, 16, 0),
            LocalDateTime.of(2020, 6, 14, 19, 30),
            CurrencyEnum.EUR,
            1);
    PVP PVP_3 = new PVP(3,
            PRODUCT_1,
            LIST_PRICE_3,
            LocalDateTime.of(2020, 6, 15, 0, 0),
            LocalDateTime.of(2020, 6, 15, 12, 0),
            CurrencyEnum.EUR,
            1);
    PVP PVP_4 = new PVP(4,
            PRODUCT_1,
            LIST_PRICE_4,
            LocalDateTime.of(2020, 6, 15, 17, 0),
            LocalDateTime.of(2020, 12, 31, 23, 59, 59),
            CurrencyEnum.EUR,
            1);



    @Test
    public void day14hour10_success () throws Exception {



        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 10, 0);
        ProductRequest productRequest = new ProductRequest(dateTime, 35455, 1);
        List<PVP> pvps = List.of(PVP_1);
        Mockito.when(pvpRepository.getPVPproductsByDate(35455, dateTime)).thenReturn(pvps);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/api/v1/pvp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(productRequest));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price.price").value(30));
    }

    @Test
    public void day14hour16_success () throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 16, 0);
        ProductRequest productRequest = new ProductRequest(dateTime, 35455, 1);
        List<PVP> pvps = List.of(PVP_1, PVP_2);
        Mockito.when(pvpRepository.getPVPproductsByDate(35455, dateTime)).thenReturn(pvps);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/api/v1/pvp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(productRequest));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price.price").value(35));
    }

    @Test
    public void day14hour21_success () throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 21, 0);
        ProductRequest productRequest = new ProductRequest(dateTime, 35455, 1);
        List<PVP> pvps = List.of(PVP_1);
        Mockito.when(pvpRepository.getPVPproductsByDate(35455, dateTime)).thenReturn(pvps);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/api/v1/pvp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(productRequest));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price.price").value(30));
    }

    @Test
    public void day15hour10_success () throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 15, 10, 0);
        ProductRequest productRequest = new ProductRequest(dateTime, 35455, 1);
        List<PVP> pvps = List.of(PVP_1, PVP_3);
        Mockito.when(pvpRepository.getPVPproductsByDate(35455, dateTime)).thenReturn(pvps);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/api/v1/pvp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(productRequest));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price.price").value(37));
    }

    @Test
    public void day15hour21_success () throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 15, 21, 0);
        ProductRequest productRequest = new ProductRequest(dateTime, 35455, 1);
        List<PVP> pvps = List.of(PVP_1, PVP_4);
        Mockito.when(pvpRepository.getPVPproductsByDate(35455, dateTime)).thenReturn(pvps);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/api/v1/pvp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(productRequest));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price.price").value(40));
    }



}
