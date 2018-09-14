package com.example.tecnologia.calculadorageometrica;

public class OpRealizadas {

    private String tipoOp;
    private String longitudes;
    private double resultado;

    public OpRealizadas() {
    }

    /*public OpRealizadas(String tipoOp, String longitudes, double resultado) {
        this.tipoOp = tipoOp;
        this.longitudes = longitudes;
        this.resultado = resultado;
    }*/

    public String getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(String tipoOp) {
        this.tipoOp = tipoOp;
    }

    public String getLongitudes() {
        return longitudes;
    }

    public void setLongitudes(String longitudes) {
        this.longitudes = longitudes;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void nuevaOp(){
        datos.guardar(this);
    }
}
