package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by 607880661 on 17/09/2018.
 */
@RestController
@RequestMapping("/api/v1/")
public class ShipWreckController {

    @Autowired
    private ShipWreckRepo shipWreckRepo;

    @RequestMapping(value ="shipwrecks", method = RequestMethod.GET)
    public List<?> getShipList()
    {
        return shipWreckRepo.findAll();
    }

    @RequestMapping(value="/shipwrecks/{id}", method=RequestMethod.GET)
    public Shipwreck getShipwreck(@PathVariable Long id)
    {
        Optional<Shipwreck> existingShipwreck =  shipWreckRepo.findById(id);
        return existingShipwreck.get();
    }

    @RequestMapping(value="/shipwrecks", method=RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck)
    {
        return shipWreckRepo.saveAndFlush(shipwreck);
    }

    @RequestMapping(value="/shipwrecks/{id}", method=RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck)
    {
        Optional<Shipwreck> existingShipwreckOption =  shipWreckRepo.findById(id);
        Shipwreck existingShipWreck = existingShipwreckOption.get();
        BeanUtils.copyProperties(shipwreck,existingShipWreck);
        return shipWreckRepo.saveAndFlush(existingShipWreck);

    }

    @RequestMapping(value="/shipwrecks/{id}", method=RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id)
    {
        Optional<Shipwreck> existingShipwreckOption =  shipWreckRepo.findById(id);
        Shipwreck existingShipWreck = existingShipwreckOption.get();
        shipWreckRepo.delete(existingShipWreck);
        return existingShipWreck;
    }
}
