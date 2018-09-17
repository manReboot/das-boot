package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by 607880661 on 18/09/2018.
 */
public class ControllerTest {

    @InjectMocks
    ShipWreckController sc;

    @Mock
    ShipWreckRepo shipWreckRepo;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllShipWreckTest()
    {
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        Optional<Shipwreck> t = Optional.of(sw);

        when(shipWreckRepo.findById(1l)).thenReturn(t);

        Shipwreck wreck = sc.getShipwreck(1L);
        verify(shipWreckRepo).findById(1l);
        assertEquals(1l,wreck.getId().longValue());
    }

}
