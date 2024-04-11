package com.example.cp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val n1 = findViewById<EditText>(R.id.txtN1);
        val n2 = findViewById<EditText>(R.id.txtN2);
        val operacaoRadioGroup = findViewById<RadioGroup>(R.id.rgOperacoes);
        val buttonCalc = findViewById<Button>(R.id.btnCalcular);

        buttonCalc.setOnClickListener {
            val valor1 = n1.text.toString().toDoubleOrNull()
            val valor2 = n2.text.toString().toDoubleOrNull()

            if (valor1 == null || valor2 == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val resultado = when (operacaoRadioGroup.checkedRadioButtonId) {
                R.id.rbSoma -> valor1 + valor2
                R.id.rbSubtracao -> valor1 - valor2
                R.id.rbMultiplicacao -> valor1 * valor2
                R.id.rbDivisao -> if (valor2 != 0.0) {
                    valor1/valor2
                } else "Não fazer divisão por zero!!!"
                else -> null
            }


            if (resultado == null) {
                Toast.makeText(this, "Operação inválida.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Resultado: $resultado", Toast.LENGTH_SHORT).show()
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    }

