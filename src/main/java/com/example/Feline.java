package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    @Override //метод интерфейса Predator
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override //метод родительского класса
    public String getFamily() {
        return "Кошачьи";
    }

    @Override //реализация метода интерфейса FelineAnimal (достался по наследству)
    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
