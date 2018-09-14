package com.example.tecnologia.calculadorageometrica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class triangulo extends Activity {
    private EditText Lado1, Lado2;
    private TextView area;
    private ArrayList<EditText> longitudes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        Lado1 = findViewById(R.id.txtBaseT);
        longitudes.add(Lado1);
        Lado2 = findViewById(R.id.txtAlturaT);
        longitudes.add(Lado2);
        area = findViewById(R.id.txtResultadoT);
    }

    public void guardarT (View v){
        double lad1, lad2, AreaOtenida;
        String TipoT, Longi;

        if (validarT()){
            Toast.makeText(this, getResources().getString(R.string.op_agregada),Toast.LENGTH_SHORT).show();
            OpRealizadas op = new OpRealizadas();
            TipoT = getString(R.string.TipoAR);
            lad1 = Double.parseDouble(Lado1.getText().toString());
            lad2 = Double.parseDouble(Lado2.getText().toString());
            Longi = "Base: "+lad1+"\n Altura: "+lad2;
            AreaOtenida = metodos.AreaT(lad1, lad2);
            op.setTipoOp(TipoT);
            op.setLongitudes(Longi);
            op.setResultado(AreaOtenida);

            op.nuevaOp();

            area.setText("El area del triangulo es: "+AreaOtenida);

            Toast.makeText(this, getResources().getString(R.string.op_agregada),Toast.LENGTH_SHORT).show();
            borrar();
        }

    }

    public void limpiar(View v){
        borrar();
    }

    private void borrar(){
        Lado1.setText("");
        Lado2.setText("");
        Lado1.requestFocus();

    }

    public boolean validarT() {
        if (Lado1.getText().toString().isEmpty()){
            Lado1.requestFocus();
            Lado1.setError(getString(R.string.Error_1));
            return false;
        }
        if (Double.parseDouble(Lado1.getText().toString()) == 0){
            Lado1.requestFocus();
            Lado1.setError(getString(R.string.Error_2));
            return false;
        }
        if (Lado2.getText().toString().isEmpty()){
            Lado2.requestFocus();
            Lado2.setError(getString(R.string.Error_1));
            return false;
        }
        if (Double.parseDouble(Lado2.getText().toString()) == 0){
            Lado2.requestFocus();
            Lado2.setError(getString(R.string.Error_2));
            return false;
        }
        return true;
    }
}
