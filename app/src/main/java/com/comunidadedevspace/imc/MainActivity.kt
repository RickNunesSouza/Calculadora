package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.comunidadedevspace.imc.R.id
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val edtPeso = findViewById<TextInputEditText>(id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(id.edt_altura)

        val btnCalcular = findViewById<Button>(id.btn_calcular)


        btnCalcular.setOnClickListener {


            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

          if (pesoStr == "" || alturaStr  == "") {


              Snackbar
                  .make(
                  edtPeso,
                  "Preencha todos os campos",
                  Snackbar.LENGTH_LONG
              )
                  .show()

          } else {
              val peso = pesoStr.toFloat()
              val altura = alturaStr.toFloat()

              val alturaQ2 = altura * altura
              val resultado = peso / alturaQ2


              val intent = Intent(this, ResultActivity::class.java)
              intent.putExtra(KEY_RESULT_IMC, resultado)

              startActivity(intent)

             // Cores
              // EditText background + icone
              //gradiente + icone + titulo + descricao
          }

        }
    }
}