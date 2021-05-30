package com.vanja.pokemon.helper;

import java.util.Random;

public class Helper {

    public static int getRandom(){
        Random r = new Random();
        int randomNumber = r.nextInt(150);
        return randomNumber;
    }
}
