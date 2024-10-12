package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CatTest {

    private static final String SOUND = "Мяу";

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    public void setUp() {
        cat = new Cat(feline); // на этот момент уже проинициализирован feline, поэтому создание cat пройдет корректно, иначе (если создавать cat в другом месте) cat=null
    }

    @Test
    void getSoundReturnMya() {
        String actual = cat.getSound();
        Assertions.assertTrue(SOUND.equals(actual), "Возвращаемое значение не соответствует ожидаемому");
    }

    @Test
    void getFoodTriggerEatMeat() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}