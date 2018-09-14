package com.example.tecnologia.calculadorageometrica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class esfera extends Activity {
    private EditText radio;
    private TextView vol;
    private ArrayList<EditText> longitudes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        radio = findViewById(R.id.txtRadio);
        longitudes.add(radio);
        vol = findViewById(R.id.txtResultadoE);
    }

    public void guardarE(View v){
        double rad, VolumenObtenido;
        String TipoE, Longi;

        if (validarC()){
            OpRealizadas op = new OpRealizadas();
            TipoE = getString(R.string.TipoVE);
            rad = Double.parseDouble(radio.getText().toString());
            Longi = "radio: "+rad;
            VolumenObtenido = metodos.VolumenE(rad);
            op.setTipoOp(TipoE);
            op.setLongitudes(Longi);
            op.setResultado(VolumenObtenido);

            op.nuevaOp();

            vol.setText("El vol del cuadrado es: "+String.format("%.2f", VolumenObtenido));

            Toast.makeText(this, getResources().getString(R.string.op_agregada),Toast.LENGTH_SHORT).show();
            borrar();
        }

    }

    public void limpiar(View v){
        borrar();
    }

    private void borrar(){
        radio.setText("");
        radio.requestFocus();

    }

    public boolean validarC() {
        if (radio.getText().toString().isEmpty()){
            radio.requestFocus();
            radio.setError(getString(R.string.Error_1));
            return false;
        }
        if (Double.parseDouble(radio.getText().toString()) == 0){
            radio.requestFocus();
            radio.setError(getString(R.string.Error_2));
            return false;
        }

        return true;

    }
}
