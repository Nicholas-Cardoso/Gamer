package br.com.learning.kotlin.services

import br.com.learning.kotlin.model.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class UseAPI {
    fun searchGame(id: Int): InfoGame {
        val path = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(path))
            .build()

        val client: HttpClient = HttpClient.newBuilder().build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val infoGames = gson.fromJson(json, InfoGame::class.java)

        return infoGames
    }
}