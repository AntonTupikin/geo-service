package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class MessageSenderImplTest {
    GeoService geoService = Mockito.mock(GeoService.class);

    LocalizationService localizationService = Mockito.mock(LocalizationService.class);

    MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

    @Test
    void sendRussiaWordsIfIpIsRussia() {
        Mockito.when(geoService.byIp(anyString())).thenReturn(new Location("Moscow", RUSSIA, null, 0));
        Mockito.when(localizationService.locale(RUSSIA)).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        Assertions.assertEquals("Добро пожаловать",messageSender.send(headers));
    }

    @Test
    void sendEnglishWordsIfIpIsUSA() {
        Mockito.when(geoService.byIp(anyString())).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(localizationService.locale(USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");



        Assertions.assertEquals("Welcome",messageSender.send(headers));
    }
}