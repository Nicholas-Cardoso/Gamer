package br.com.learning.kotlin.home


import br.com.learning.kotlin.model.PeriodRent
import br.com.learning.kotlin.model.SubPlan
import br.com.learning.kotlin.services.UseAPI
import java.time.LocalDate

fun main() {
    val useAPI = UseAPI()
    val gamer = useAPI.searchGamerJson().get(4)

    gamer.plan = SubPlan("PRATA", 9.90, 3, 0.1)

    val game = useAPI.searchGameJson().get(10)
    val game2 = useAPI.searchGameJson().get(8)
    val game3 = useAPI.searchGameJson().get(6)

    val period = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(5))
    val period2 = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(6))
    val period3 = PeriodRent(LocalDate.now(), LocalDate.now().plusDays(7))

    gamer.recommend(8)
    gamer.recommend(8)
    gamer.recommend(10)

    gamer.rentGame(game, period)
    gamer.rentGame(game2, period2)
    gamer.rentGame(game3, period3)

    println(gamer)

    println(gamer.listRents)
}