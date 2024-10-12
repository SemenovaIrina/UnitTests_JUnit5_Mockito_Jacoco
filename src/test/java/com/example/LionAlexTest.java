package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.Constants.ALEX_FRIENDS;
import static com.example.Constants.ALEX_PLACE_OF_LIVING;

@ExtendWith(MockitoExtension.class)
public class LionAlexTest {

    @Mock
    private FelineAnimal felineAlex;

    private LionAlex lionAlex;

    @BeforeEach
    public void setUp() throws Exception {
        lionAlex = new LionAlex(felineAlex);
    }

    @Test
    public void doesHaveManeReturnMale() {
        boolean actual = lionAlex.doesHaveMane();
        Assertions.assertEquals(true, actual, "Возвращаемое значение не соответствует ожидаемому");
    }

    @Test
    public void getKittensReturnZero() {
        int actual = lionAlex.getKittens();
        Assertions.assertEquals(0, actual, "Возвращаемое значение не соответствует ожидаемому");
    }

    @Test
    public void getPlaceOfLivingReturnZoo() {
        String actual = lionAlex.getPlaceOfLiving();
        Assertions.assertTrue(ALEX_PLACE_OF_LIVING.equals(actual), "Возвращаемое значение не соответствует ожидаемому");
    }

    @Test
    public void getFriendsReturnList() {
        List<String> actual = lionAlex.getFriends();
        Assertions.assertArrayEquals(ALEX_FRIENDS.toArray(), actual.toArray(), "Возвращаемый список значений не соответствует ожидаемому");

    }

    // метод getFood() не переопределяется в наследнике, а значит он покрыт тестами родительского класса

}

