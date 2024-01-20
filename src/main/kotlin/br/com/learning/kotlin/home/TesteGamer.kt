import br.com.learning.kotlin.model.Gamer

fun main() {
    val gamerOne = Gamer(
        "Nicholas",
        "delldutry12@gmail.com"
    )
    println(gamerOne)

    val gamerTwo = Gamer(
        "TesterMan",
        "testerman@gmail.com",
        "01/01/2020",
        "TesterMan"
    )
    println(gamerTwo)
}