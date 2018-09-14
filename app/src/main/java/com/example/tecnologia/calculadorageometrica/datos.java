package com.example.tecnologia.calculadorageometrica;

import java.util.ArrayList;

public class datos {

    private static ArrayList<OpRealizadas> OpR = new ArrayList<>();

    public static void guardar (OpRealizadas o){
        OpR.add(o);
    }

    public static ArrayList<OpRealizadas> obtener(){
        return OpR;
    }

}
