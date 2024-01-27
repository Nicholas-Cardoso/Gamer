package br.com.learning.kotlin.home

import br.com.learning.kotlin.data.Database
import br.com.learning.kotlin.data.GamersDAO
import br.com.learning.kotlin.data.GamesDAO
import br.com.learning.kotlin.data.RentDAO
import br.com.learning.kotlin.model.PeriodRent

fun main() {
    val manager = Database.getEntityManager()
    val jogoDAO = GamesDAO(manager)
    val gamerDAO = GamersDAO(manager)
    val aluguelDAO = RentDAO(manager)

    val gamer = gamerDAO.findForId(1)
    val jogo = jogoDAO.findForId(2)
    val aluguel = gamer.rentGame(jogo, PeriodRent())

    aluguelDAO.create(aluguel)

    val listaAluguel = aluguelDAO.getList()
    println(listaAluguel)

    manager.close()
}