package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.*;

class LocalizationServiceImplTest {
    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void localeReturnWelcomeIfYouInUSA() {
        Assertions.assertEquals("Welcome",localizationService.locale(USA));
    }
@Test
    void localeReturnWelcomeIfYouInRussia() {
        Assertions.assertEquals("Добро Пожаловать",localizationService.locale(RUSSIA));
    }
}