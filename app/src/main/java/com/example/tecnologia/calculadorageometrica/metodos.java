package com.example.tecnologia.calculadorageometrica;

public class metodos {

    public static double AreaC(double lado){
        double areac = lado * lado;
        return areac;
    }

    public static double AreaR(double base, double altura){
        double arear = base * altura;
        return arear;
    }

    public static double AreaT(double base, double altura){
        double areat = base * altura;
        return areat/2;
    }

    public  static double VolumenC (double arista){
        double vcu = Math.pow(arista,3);
        return vcu;
    }

    public static double VolumenE (double radio){
        double ves = (4*(Math.PI*(Math.pow(radio,3))))/3;
        return ves;
    }

    public static double VolumenCi (double radio, double altura){
        double vci = Math.PI*(Math.pow(radio,2))*altura;
        return vci;
    }



}
