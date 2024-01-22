package br.com.learning.kotlin.services

import br.com.learning.kotlin.model.*
import br.com.learning.kotlin.utility.transformGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import transformGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class UseAPI {
    private fun useData(url: String): String {
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val client: HttpClient = HttpClient.newBuilder().build()
        val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun searchGame(id: Int): InfoGame {
        val path = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = useData(path)

        val gson = Gson()

        return gson.fromJson(json, InfoGame::class.java)
    }

    fun searchGameJson(): List<GameJson> {
        val path = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val json = useData(path)

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoGameJson>>() {}.type
        val listGame: List<InfoGameJson> = gson.fromJson(json, gamerType)

        return listGame.map { infoGameJson -> infoGameJson.transformGame() }
    }

    fun searchGamerJson(): List<Gamer> {
        val path = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = useData(path)

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listGamer: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        return listGamer.map { infoGamerJson -> infoGamerJson.transformGamer() }
    }
}