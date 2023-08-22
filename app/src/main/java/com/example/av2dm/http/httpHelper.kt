package com.example.av2dm.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class httpHelper {

    fun post (json: String) : String{
        //Definir URL do servidor
        val URL = "192.168.0.12:8080/dentistas"

        // definir o cabeçalho
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        // criar um cliente que vai disparar a requisição
        val client = OkHttpClient()

        // criar o body da requisição
        val body = RequestBody.create(headerHttp, json)

        // construir a requisição http para o servidor
        var request = Request.Builder().url(URL).build()

        // utilizar o client para fazer a requisição e receber a resposta
        val response = client.newCall(request).execute()

        return response.body().toString()
    }

}