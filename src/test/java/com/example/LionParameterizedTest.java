package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static com.example.Constants.SEX;
import static org.junit.jupiter.params.provider.Arguments.arguments;

//junit5 позволяет реализовать этот тест вместе с другими тестами в классе LionTest,
//но в задании указано, чтобы параметризованные тесты были в отдельном классе

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    private FelineAnimal feline;

    private Lion lion;

    public static Stream<Arguments> isEvenData() {
        return Stream.of(
                arguments(SEX[0], true),
                arguments(SEX[1], false)
        );
    }

    @ParameterizedTest
    @MethodSource("isEvenData")
    public void createLionObjectWithCorrectSex(String sex, boolean result) throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        Assertions.assertEquals(result, actual, "Возвращаемое значение не соответствует ожидаемому");
    }
}
