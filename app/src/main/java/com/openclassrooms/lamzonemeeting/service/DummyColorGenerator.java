package com.openclassrooms.lamzonemeeting.service;

import android.graphics.Color;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DummyColorGenerator {
    public static List<Integer> DUMMY_COLOR = Arrays.asList(Color.argb(255,237,217,208),
            Color.argb(255,174,206,184),
            Color.argb(255,135,186,243),
            Color.argb(255,250,148,162),
            Color.argb(255,234,225,168),
            Color.argb(255,155,227,240),
            Color.argb(255,155,227,240));


    public static int dummyColorReturn(){
        Random r = new Random();
        int i = r.nextInt(DUMMY_COLOR.size()-1);

        return DUMMY_COLOR.get(i);

    }
}

