package br.com.learning.kotlin.home


import br.com.learning.kotlin.services.UseAPI
import com.google.gson.GsonBuilder
import java.io.File

fun main() {
    val useAPI = UseAPI()

    val gamerCaroline = useAPI.searchGamerJson().get(3)
    val jogoResidentVillage = useAPI.searchGameJson().get(10)
    val jogoSpider = useAPI.searchGameJson().get(13)
    val jogoTheLastOfUs = useAPI.searchGameJson().get(2)
    val jogoDandara = useAPI.searchGameJson().get(5)
    val jogoAssassins = useAPI.searchGameJson().get(4)
    val jogoCyber = useAPI.searchGameJson().get(6)
    val jogoGod = useAPI.searchGameJson().get(7)
    val jogoSkyrim = useAPI.searchGameJson().get(18)

    gamerCaroline.recommendGame(jogoResidentVillage, 7)
    gamerCaroline.recommendGame(jogoTheLastOfUs, 10)
    gamerCaroline.recommendGame(jogoAssassins, 8)
    gamerCaroline.recommendGame(jogoCyber, 7)
    gamerCaroline.recommendGame(jogoGod, 10)
    gamerCaroline.recommendGame(jogoDandara, 8)
    gamerCaroline.recommendGame(jogoSkyrim, 8)
    gamerCaroline.recommendGame(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializer = gson.toJson(gamerCaroline.listRecommendGame)

    println(serializer)

    val file = File("gamesRecommended.json")
    file.writeText(serializer)

    println(file.absoluteFile)
}