package com.example.av2dm


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.av2dm.model.Dentista
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAbrirCadastroDentista = findViewById<Button>(R.id.button_abrir_cadastro_dentista)

        buttonAbrirCadastroDentista.setOnClickListener {
            try {
                val abrirCadastroDentista = Intent(this, CadastroDentistaActivity::class.java)
                startActivity(abrirCadastroDentista)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

                var dentista = Dentista()
                dentista.nome = "Antonio da Silva"
                dentista.cro = "1234"
                dentista.email = "antonio@teste.com.br"
                dentista.telefone = "000000000"

                println("=========> " + dentista)

                //instanciar objeto gson
                var gson = Gson()

                //converter dentista em gson
                var dentistaJson = gson.toJson(dentista)

                println("--------> " + dentistaJson)

                //converter json em um objeto dentista
                var dentista2: Dentista

                dentista2  = gson.fromJson(dentistaJson, Dentista::class.java)

                println("========dentista2>" + dentista2)

    }
}