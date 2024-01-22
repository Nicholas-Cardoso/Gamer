package br.com.learning.kotlin.model

class SubPlan(
    type: String,
    val monthlyPay: Double,
    val quantityGames: Int,
    val valueDiscount: Double
) : Plan(type) {
    override fun getValue(rent: Rent): Double {
        val totalGamesInMonth = rent.gamer.gamesInMonth(rent.period.startDate.monthValue).size+1

        return if (totalGamesInMonth <= quantityGames) {
            0.0
        } else {
            var originValue = super.getValue(rent)

            if (rent.gamer.avg > 8) {
                originValue -= originValue * valueDiscount
            }
            originValue
        }
    }
}