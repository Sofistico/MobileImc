package com.pucpr.mobile1_appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularIMC(View view) {

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());

        //IMC é calculado como PESO/ALTURAxALTURA

        double imc = peso/(altura*altura);
        StringBuilder strBuilder = new StringBuilder();
        if(imc < 18.5){
            strBuilder.append("Abaixo do peso");
        }
        else if(imc >= 18.5 && imc <= 24.99) {
            strBuilder.append("Peso está normal");
        }else if(imc >= 25 && imc <= 29.99) {
            strBuilder.append("Acima do peso");
        }else if(imc >= 30 && imc <= 34.99) {
            strBuilder.append("Obesidade 1°");
        }else if(imc >= 35 && imc <= 39.99) {
            strBuilder.append("Obesidade 2°");
        }else if(imc >= 40) {
            strBuilder.append("Obesidade 3°");
        }
        strBuilder.append(", IMC = " + imc);

        textResultado.setText(strBuilder.toString());
    }

    public void cleanFields(View view){
        editAltura.setText("");
        editPeso.setText("");
        textResultado.setText("");
    }
}