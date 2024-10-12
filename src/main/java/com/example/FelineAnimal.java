package com.example;

import java.util.List;

//интерфейс для устранения зависимости между Lion Feline
public interface FelineAnimal {

    List<String> getFood(String animalKind) throws Exception;

    int getKittens();

}
