package com.example.toast

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.String.valueOf

class Calculadora : AppCompatActivity() {


    private lateinit var editVar1 : EditText
    private lateinit var editVar2 : EditText

    private lateinit var BtnSoma: Button
    private lateinit var BtnSubtracao: Button
    private lateinit var BtnDivide: Button
    private lateinit var BtnMultiplca: Button

    private lateinit var txtResult: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editVar1 = findViewById(R.id.editVar1)
        editVar2 = findViewById(R.id.editVar2)


        txtResult = findViewById(R.id.txtResult)

        BtnSoma = findViewById(R.id.btnMais)
        BtnSubtracao = findViewById(R.id.btnMenos)
        BtnDivide = findViewById(R.id.btnDivide)
        BtnMultiplca = findViewById(R.id.btnMultiplca)

        val var1 = editVar1.text.toString().toInt()
        val var2 = editVar2.text.toString().toInt()

        BtnSoma.setOnClickListener {
            txtResult.text = "${(soma(var1, var2))}"
            //soma(10, 10)
            //->20
        }

        BtnSubtracao.setOnClickListener {
            txtResult.text= "${(subtracao(var1, var2))}"
            //subtracao(10, 5)
            //->15
        }

        BtnDivide.setOnClickListener {
            txtResult.text= "${(divisao(var1, var2))}"
            //divisao(10, 5)
            //->2
        }

        BtnMultiplca.setOnClickListener {
            txtResult.text= "${(multiplicacao(var1, var2))}"
            //multiplicacao(10, 5)
            //->50
        }
    }

    private fun soma(a: Int, b: Int): Int {
        return a + b
    }

    private fun subtracao(a: Int, b: Int): Int {
        return a - b
    }

    private fun multiplicacao(a: Int, b: Int): Int {
        return a * b
    }

    private fun divisao(a: Int, b: Int): Int {
        if (b == 0) {
            throw ArithmeticException("Divisão por zero não permitida!")
        }
        return a / b
    }
}