package com.example.tecnologia.calculadorageometrica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaOpRealizadas extends Activity {

    private TableLayout tabla;
    private ArrayList<OpRealizadas> OperacionesR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_op_realizadas);

        tabla = findViewById(R.id.tabla);
        OperacionesR = datos.obtener();

        for (int i = 0; i < OperacionesR.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            c1.setText(String.valueOf(i+1));
            c1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            c2.setText(OperacionesR.get(i).getTipoOp());
            c2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            c3.setText(OperacionesR.get(i).getLongitudes());
            c3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            c4.setText(String.format("%.2f", OperacionesR.get(i).getResultado()));
            c4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            tabla.addView(fila);
            tabla.setStretchAllColumns(true);
        }
    }
}
