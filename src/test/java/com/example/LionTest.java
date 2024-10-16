package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static com.example.Constants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private FelineAnimal feline;

    private Lion lion;

    @Test
    public void createLionObjectWithException() throws Exception {
        Throwable thrown = assertThrows(Exception.class, () -> {
                    lion = new Lion(SEX[2], feline);
                },
                "Исключение не возникает или не соответствует ожидаемому");
        Assertions.assertTrue(EXCEPTION_MESSAGE.equals(thrown.getMessage()), "Исключение не возникает или не соответствует ожидаемому");
    }

    @Test
    public void getKittensTriggerGetKittensForFelineFild() throws Exception {
        Random rn = new Random();
        lion = new Lion(SEX[rn.nextInt(2)], feline);  //не важно какой пол
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    void getFoodTriggerGetFoodForPredator() throws Exception {
        Random rn = new Random();
        lion = new Lion(SEX[rn.nextInt(2)], feline);  //не важно какой пол
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(KIND_ANIMAL);
    }
}