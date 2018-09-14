package com.example.tecnologia.calculadorageometrica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cilindro extends Activity {
    private EditText radio, altura;
    private TextView vol;
    private ArrayList<EditText> longitudes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        radio = findViewById(R.id.txtRadio);
        longitudes.add(radio);
        altura = findViewById(R.id.txtAltura);
        longitudes.add(altura);
        vol = findViewById(R.id.txtResultadoCi);
    }

    public void guardarCi (View v){
        double rad1, altura, VolumenObtenido;
        String TipoCi, Longi;

        if (validarR()){
            Toast.makeText(this, getResources().getString(R.string.op_agregada),Toast.LENGTH_SHORT).show();
            OpRealizadas op = new OpRealizadas();
            TipoCi = getString(R.string.TipoVCi);
            rad1 = Double.parseDouble(radio.getText().toString());
            altura = Double.parseDouble(this.altura.getText().toString());
            Longi = "Radio: "+rad1+"\n Altura: "+altura;
            VolumenObtenido = metodos.VolumenCi(rad1, altura);
            op.setTipoOp(TipoCi);
            op.setLongitudes(Longi);
            op.setResultado(VolumenObtenido);

            op.nuevaOp();

            vol.setText("El volumen del cilindro es: "+String.format("%.2f", VolumenObtenido));

            Toast.makeText(this, getResources().getString(R.string.op_agregada),Toast.LENGTH_SHORT).show();
            borrar();
        }

    }

    public void limpiar(View v){
        borrar();
    }

    private void borrar(){
        radio.setText("");
        altura.setText("");
        radio.requestFocus();

    }

    public boolean validarR() {
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
        if (altura.getText().toString().isEmpty()){
            altura.requestFocus();
            altura.setError(getString(R.string.Error_1));
            return false;
        }
        if (Double.parseDouble(altura.getText().toString()) == 0){
            altura.requestFocus();
            altura.setError(getString(R.string.Error_2));
            return false;
        }
        return true;
    }
}
