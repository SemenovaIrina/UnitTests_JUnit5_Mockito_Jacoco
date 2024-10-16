package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static com.example.Constants.FELINE_FAMILY;
import static com.example.Constants.PREDATOR_FOOD;

@ExtendWith(MockitoExtension.class) //для junit5
class FelineTest {

    @Spy // шпион для объекта
    private Feline feline; //создается с помощью конструктора по умолчанию

    @Test
    void eatMeatTriggerGetFoodForPredator() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }


    @Test
    void getFoodReturnListFoodForPredator() throws Exception {
        List<String> actual = feline.eatMeat();
        Assertions.assertArrayEquals(PREDATOR_FOOD.toArray(), actual.toArray(), "Возвращаемый список значений не соответствует ожидаемому");
    }

    @Test
    void getFamilyReturnFeline() {
        String actual = feline.getFamily();
        Assertions.assertTrue(FELINE_FAMILY.equals(actual), "Возвращаемое значение не соответствует ожидаемому");
    }

    @Test
    void getKittensDefaultParamIsOne() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    void getKittensReturnIntValue() {
        Random rand = new Random();
        int expexted = rand.nextInt(10);
        int actual = feline.getKittens(expexted);
        Assertions.assertEquals(expexted, actual, "Возвращаемое значение не соответствует ожидаемому");
    }
}
