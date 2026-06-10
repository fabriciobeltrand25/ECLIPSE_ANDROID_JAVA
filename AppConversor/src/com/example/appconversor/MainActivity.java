package com.example.appconversor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    private Spinner spDe, spA;
    private EditText etValor, etResultado;
    private Button btnConvertir, btnLimpiar;
    private String[] unidades = {"C", "F", "cm", "mts", "km", "m", "lb", "kg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDe = (Spinner) findViewById(R.id.spDe);
        spA = (Spinner) findViewById(R.id.spA);
        etValor = (EditText) findViewById(R.id.etValor);
        etResultado = (EditText) findViewById(R.id.etResultado);
        btnConvertir = (Button) findViewById(R.id.btnConvertir);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, unidades);
        spDe.setAdapter(adapter);
        spA.setAdapter(adapter);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarConversion();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etValor.setText("");
                etResultado.setText("");
            }
        });
    }

    private void realizarConversion() {
        if (etValor.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
            return;
        }

        String de = spDe.getSelectedItem().toString();
        String a = spA.getSelectedItem().toString();
        double valor = Double.parseDouble(etValor.getText().toString());
        double res = 0;

        // Lógica de validación de tipos
        boolean esTemperatura = (de.equals("C") || de.equals("F")) && (a.equals("C") || a.equals("F"));
        boolean esPeso = (de.equals("kg") || de.equals("lb")) && (a.equals("kg") || a.equals("lb"));
        boolean esLongitud = (de.equals("cm") || de.equals("mts") || de.equals("km") || de.equals("m")) && 
                             (a.equals("cm") || a.equals("mts") || a.equals("km") || a.equals("m"));

        if (esTemperatura) {
            if (de.equals(a)) res = valor;
            else if (de.equals("C")) res = (valor * 9/5) + 32;
            else res = (valor - 32) * 5/9;
        } else if (esPeso) {
            if (de.equals(a)) res = valor;
            else if (de.equals("kg")) res = valor * 2.20462;
            else res = valor / 2.20462;
        } else if (esLongitud) {
            // Ejemplo básico: convertir todo a metros primero
            double enMetros = 0;
            if (de.equals("cm")) enMetros = valor / 100;
            else if (de.equals("mts") || de.equals("m")) enMetros = valor;
            else if (de.equals("km")) enMetros = valor * 1000;
            
            if (a.equals("cm")) res = enMetros * 100;
            else if (a.equals("mts") || a.equals("m")) res = enMetros;
            else if (a.equals("km")) res = enMetros / 1000;
        } else {
            Toast.makeText(this, "Error operacion imcopatible", Toast.LENGTH_LONG).show();
            etResultado.setText("");
            return;
        }

        etResultado.setText(String.format("%.2f", res));
    }
}