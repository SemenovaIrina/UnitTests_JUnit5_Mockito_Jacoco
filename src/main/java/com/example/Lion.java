package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    FelineAnimal felineAnimal;

    //инъекция зависимости
    public Lion(String sex, FelineAnimal feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.felineAnimal = feline;
    }

    public int getKittens() {
        return felineAnimal.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return felineAnimal.getFood("Хищник");
    }
}
