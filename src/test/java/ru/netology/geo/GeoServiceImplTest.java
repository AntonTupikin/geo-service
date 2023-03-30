package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.*;


class GeoServiceImplTest {
    GeoService geoService = new GeoServiceImpl();


    @Test
    void testRussianIp() {
        Assertions.assertEquals(RUSSIA,geoService.byIp("172.165.203.5").getCountry());
        ;
    }
    @Test
    void testUsaIp() {
        Assertions.assertEquals(USA,geoService.byIp("96.165.203.5").getCountry());
        ;
    }
}