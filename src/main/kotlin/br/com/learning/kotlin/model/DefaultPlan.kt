package br.com.learning.kotlin.model

class DefaultPlan(
    type: String
) : Plan(type) {
    override fun getValue(rent: Rent): Double {
        var originValue = super.getValue(rent)

        if (rent.gamer.avg > 8) {
            originValue -= originValue * 0.1
        }
        return originValue
    }
}