package com.example.cp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelefoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telefone)

        val valorFixo = findViewById<EditText>(R.id.txtTaxa)
        val valorEdit1 = findViewById<EditText>(R.id.txtMinLoc)
        val valorEdit2 = findViewById<EditText>(R.id.txtCel)
        val buttonCalc = findViewById<Button>(R.id.btnCalcularTel)


        buttonCalc.setOnClickListener {


            val taxa = valorFixo.text.toString().toDoubleOrNull()
            val valor1 = valorEdit1.text.toString().toDoubleOrNull()
            val valor2 = valorEdit2.text.toString().toDoubleOrNull()

            if (valor1 == null || valor2 == null || taxa == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultado1 = valor1 * 0.04
            val resultado2 = valor2 * 0.20


            val intent = Intent(this, ResultadoActivity::class.java).apply {
                putExtra("taxa", taxa)
                putExtra("resultado1", resultado1)
                putExtra("resultado2", resultado2)
            }
            startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


}
