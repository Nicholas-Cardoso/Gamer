package br.com.learning.kotlin.model

data class Rent(
    val gamer: Gamer,
    val game: GameJson,
    val period: PeriodRent
) {
    private val rentValue = gamer.plan.getValue(this)
    override fun toString(): String {
        return "Game ${game.titulo} alugado por ${gamer.name} pelo preço R$$rentValue"
    }
}