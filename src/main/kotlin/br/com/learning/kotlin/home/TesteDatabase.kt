package br.com.learning.kotlin.home

import br.com.learning.kotlin.data.Database
import br.com.learning.kotlin.data.GamersDAO
import br.com.learning.kotlin.data.GamesDAO
import br.com.learning.kotlin.model.GameJson
import br.com.learning.kotlin.model.Gamer

fun main() {
    val manager = Database.getEntityManager()

    val game = GameJson(
        "The Witcher 3: Wild Hunt",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/292030/header.jpg?t=1675178392",
        "Um RPG de ação épico com um mundo aberto vasto e envolvente.",
        4.99,
        0
    )
    val gamer = Gamer(
        "Nicholas",
        "delldutry12@gmail.com",
        "08-06-2006",
        "LinuxFPS",
        0
    )

    val gamesDAO = GamesDAO(manager)
    val gamersDAO = GamersDAO(manager)

//    gamersDAO.create(gamer)
//    gamesDAO.create(game)

//    val resultGames = gamesDAO.getList()
//    val resultGamer = gamersDAO.getList()

    val removeGames = gamesDAO.findForId(2)
//    println(resultGames)
//    println(resultGamer)
    println(removeGames)
}