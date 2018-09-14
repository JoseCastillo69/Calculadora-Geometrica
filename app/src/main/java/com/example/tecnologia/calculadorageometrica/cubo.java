package com.example.tecnologia.calculadorageometrica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cubo extends Activity {
    private EditText Arista;
    private TextView vol;
    private ArrayList<EditText> longitudes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        Arista = findViewById(R.id.txtArista);
        longitudes.add(Arista);
        vol = findViewById(R.id.txtResultadoCu);
    }

    public void guardarCu (View v){
        double ari1, VolumenObtenido;
        String TipoCu, Longi;

        if (validarC()){
            OpRealizadas op = new OpRealizadas();
            TipoCu = getString(R.string.TipoVCu);
            ari1 = Double.parseDouble(Arista.getText().toString());
            Longi = "Arista: "+ari1;
            VolumenObtenido = metodos.VolumenC(ari1);
            op.setTipoOp(TipoCu);
            op.setLongitudes(Longi);
            op.setResultado(VolumenObtenido);

            op.nuevaOp();

            vol.setText("El vol del cuadrado es: "+VolumenObtenido);

            Toast.makeText(this, getResources().getString(R.string.op_agregada),Toast.LENGTH_SHORT).show();
            borrar();
        }

    }

    public void limpiar(View v){
        borrar();
    }

    private void borrar(){
        Arista.setText("");
        Arista.requestFocus();

    }

    public boolean validarC() {
        if (Arista.getText().toString().isEmpty()){
            Arista.requestFocus();
            Arista.setError(getString(R.string.Error_1));
            return false;
        }
        if (Double.parseDouble(Arista.getText().toString()) == 0){
            Arista.requestFocus();
            Arista.setError(getString(R.string.Error_2));
            return false;
        }

        return true;

    }
}
