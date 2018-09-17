package com.boot.repository;

import com.boot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 607880661 on 18/09/2018.
 */
public interface ShipWreckRepo extends JpaRepository<Shipwreck,Long>{
}
