package com.example.tecnologia.calculadorageometrica;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cuadrado extends Activity {

    private EditText Lado;
    private TextView area;
    private ArrayList<EditText> longitudes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        Lado = findViewById(R.id.txtLado);
        longitudes.add(Lado);
        area = findViewById(R.id.txtResultadoC);
    }

    public void guardarC (View v){
        double lad1, AreaOtenida;
        String TipoC, Longi;

        if (validarC()){
            OpRealizadas op = new OpRealizadas();
            TipoC = getString(R.string.TipoAC);
            lad1 = Double.parseDouble(Lado.getText().toString());
            Longi = "Lado: "+lad1;
            AreaOtenida = metodos.AreaC(lad1);
            op.setTipoOp(TipoC);
            op.setLongitudes(Longi);
            op.setResultado(AreaOtenida);

            op.nuevaOp();

            area.setText("El area del cuadrado es: "+AreaOtenida);

            Toast.makeText(this, getResources().getString(R.string.op_agregada),Toast.LENGTH_SHORT).show();
            borrar();
        }

    }

    public void limpiar(View v){
        borrar();
    }

    private void borrar(){
        Lado.setText("");
        Lado.requestFocus();

    }

    public boolean validarC() {
        if (Lado.getText().toString().isEmpty()){
            Lado.requestFocus();
            Lado.setError(getString(R.string.Error_1));
            return false;
        }
        if (Double.parseDouble(Lado.getText().toString()) == 0){
            Lado.requestFocus();
            Lado.setError(getString(R.string.Error_2));
            return false;
        }

        return true;

    }




}
