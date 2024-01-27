package br.com.learning.kotlin.model

class DefaultPlan(
    type: String,
    id: Int = 0
) : Plan(type, id) {
    override fun getValue(rent: Rent): Double {
        var originValue = super.getValue(rent)

        if (rent.gamer.avg > 8) {
            originValue -= originValue * 0.1
        }
        return originValue
    }

    override fun toString(): String {
        return "Type=$type, \n" +
                "Id=$id"
    }
}