package com.theloop.challenge.Repositories;

import com.theloop.challenge.Models.PVP;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PVPRepository extends CrudRepository<PVP, Integer> {

    @Query("SELECT p FROM PVP p WHERE p.product.id = ?1 AND ?2 BETWEEN  p.startDate and p.endDate")
    List<PVP> getPVPproductsByDate(int productId, LocalDateTime date);
}
