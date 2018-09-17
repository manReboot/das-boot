package com.boot.controller;

import com.boot.model.Shipwreck;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 607880661 on 17/09/2018.
 */
@RestController
@RequestMapping("/api/v1/")
public class ShipWreckController {

    @RequestMapping(value ="shipwrecks", method = RequestMethod.GET)
    public List<?> getShipList()
    {
        return ShipwreckStub.list();
    }

    @RequestMapping(value="/shipwrecks/{id}", method=RequestMethod.GET)
    public Shipwreck getShipwreck(@PathVariable Long id)
    {
        return ShipwreckStub.get(id);
    }

    @RequestMapping(value="/shipwrecks", method=RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck)
    {
        return ShipwreckStub.create(shipwreck);
    }

    @RequestMapping(value="/shipwrecks/{id}", method=RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id)
    {
        return ShipwreckStub.delete(id);
    }
}
