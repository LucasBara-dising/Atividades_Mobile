package com.example.toast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calcualdora_java extends AppCompatActivity {

    private EditText editVar1;
    private EditText editVar2;

    private Button BtnSoma;
    private Button BtnSubtracao;
    private Button BtnDivide;
    private Button BtnMultiplca;

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcualdora_java);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editVar1 = findViewById(R.id.editVar1);
        editVar2 = findViewById(R.id.editVar2);

        txtResult = findViewById(R.id.txtResult);

        BtnSoma = findViewById(R.id.btnMais);
        BtnSubtracao = findViewById(R.id.btnMenos);
        BtnDivide = findViewById(R.id.btnDivide);
        BtnMultiplca = findViewById(R.id.btnMultiplca);

        BtnSoma.setOnClickListener(view -> {
            try {
                int var1 = Integer.parseInt(editVar1.getText().toString());
                int var2 = Integer.parseInt(editVar2.getText().toString());
                txtResult.setText(String.valueOf(soma(var1, var2)));
            } catch (NumberFormatException e) {
                Toast.makeText(Calcualdora_java.this, "Por favor, insira números válidos!", Toast.LENGTH_SHORT).show();
            }
        });

        BtnSubtracao.setOnClickListener(view -> {
            try {
                int var1 = Integer.parseInt(editVar1.getText().toString());
                int var2 = Integer.parseInt(editVar2.getText().toString());
                txtResult.setText(String.valueOf(subtracao(var1, var2)));
            } catch (NumberFormatException e) {
                Toast.makeText(Calcualdora_java.this, "Por favor, insira números válidos!", Toast.LENGTH_SHORT).show();
            }
        });

        BtnDivide.setOnClickListener(view -> {
            try {
                int var1 = Integer.parseInt(editVar1.getText().toString());
                int var2 = Integer.parseInt(editVar2.getText().toString());
                txtResult.setText(String.valueOf(divisao(var1, var2)));
            } catch (NumberFormatException e) {
                Toast.makeText(Calcualdora_java.this, "Por favor, insira números válidos!", Toast.LENGTH_SHORT).show();
            } catch (ArithmeticException e) {
                Toast.makeText(Calcualdora_java.this, "Divisão por zero não permitida!", Toast.LENGTH_SHORT).show();
            }
        });

        BtnMultiplca.setOnClickListener(view -> {
            try {
                int var1 = Integer.parseInt(editVar1.getText().toString());
                int var2 = Integer.parseInt(editVar2.getText().toString());
                txtResult.setText(String.valueOf(multiplicacao(var1, var2)));
            } catch (NumberFormatException e) {
                Toast.makeText(Calcualdora_java.this, "Por favor, insira números válidos!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int soma(int a, int b) {
        return a + b;
    }

    private int subtracao(int a, int b) {
        return a - b;
    }

    private int multiplicacao(int a, int b) {
        return a * b;
    }

    private int divisao(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida!");
        }
        return a / b;
    }
}