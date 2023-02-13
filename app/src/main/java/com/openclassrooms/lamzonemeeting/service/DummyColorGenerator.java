package com.openclassrooms.lamzonemeeting.service;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * tableau de couleurs pour rendre une couleur aléatoire et l'attribuer à une reunion
 */
public class DummyColorGenerator {

    public static List<Integer> listColorReturn(){
        return new ArrayList<>(DUMMY_COLOR);
    }

  /*  public static List<Integer> DUMMY_COLOR = Arrays.asList(Color.rgb(237,217,208),
            Color.rgb(174,206,184),
            Color.rgb(135,186,243),
            Color.rgb(250,148,162),
            Color.rgb(234,225,168),
            Color.rgb(155,227,240),
            Color.rgb(155,227,240)); */

    public static List<Integer> DUMMY_COLOR = Arrays.asList(-5321032,
            -7881997,
            -355166,
            -1384024,
            -6560784,
            -1189424);



    /**
     *
     * entier qui correspond à une couleur prise aléatoirement dans le tableau de couleurs
     */
    public static int dummyColorReturn(){

        Random r = new Random();

        int i = r.nextInt(DUMMY_COLOR.size()-1);

        return DUMMY_COLOR.get(i);

    }
}

