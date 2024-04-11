package com.example.cp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAluno = findViewById<Button>(R.id.btnAluno);
        val buttonCalc = findViewById<Button>(R.id.btncalculadora)
        val buttonContaTel = findViewById<Button>(R.id.btnContaTel)

        buttonAluno.setOnClickListener {
            val mySignature = """
            Nome: Thomas Nícolas de Melo Mendonça
            RM: 99832
        """.trimIndent()

            AlertDialog.Builder(this)
                .setTitle("Desenvolvido Por")
                .setMessage(mySignature)
                .setPositiveButton("Ok") { dialog, which ->

                }
                .show()
        }
        buttonCalc.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }
        buttonContaTel.setOnClickListener {
            val intent = Intent(this, TelefoneActivity::class.java)
            startActivity(intent)
        }


    }

}