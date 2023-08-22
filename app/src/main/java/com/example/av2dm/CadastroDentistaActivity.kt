package com.example.av2dm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.av2dm.http.httpHelper
import com.example.av2dm.model.Dentista
import com.google.gson.Gson
import kotlinx.coroutines.*

class CadastroDentistaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_dentista)

        val buttonGravar = findViewById<Button>(R.id.button_gravar)
        val editTextNome = findViewById<EditText>(R.id.edit_text_nome)
        val editTextCro = findViewById<EditText>(R.id.edit_text_cro)
        val editTextEmail = findViewById<EditText>(R.id.edit_text_email)
        val editTextTelefone = findViewById<EditText>(R.id.edit_text_telefone)

        buttonGravar.setOnClickListener {
            // criar objeto dentista
            val dentista = Dentista()
            dentista.nome = editTextNome.text.toString()
            dentista.cro = editTextCro.text.toString()
            dentista.email = editTextEmail.text.toString()
            dentista.telefone = editTextTelefone.text.toString()

            //converter em json
            val gson = Gson()
            val dentistaJson = gson.toJson(dentista)

            //Exibir os dados no Logcat
            println("Dados inseridos ===> " + dentistaJson)

            // exibir os dados inseridos em um Toast
            Toast.makeText(this, dentistaJson, Toast.LENGTH_SHORT).show()



            fun main() = runBlocking {
                launch(Dispatchers.IO) {
                    val http = httpHelper()
                    http.post(dentistaJson)
                }
            }

        }

    }
}