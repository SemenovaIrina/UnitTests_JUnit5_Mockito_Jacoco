package com.example;

import java.util.List;

import static com.example.Constants.SEX;

public class LionAlex extends Lion {

    LionAlex(FelineAnimal feline) throws Exception {
        super(SEX[0], feline); //Самец
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глории", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }

}




