package br.com.learning.kotlin.model

sealed class Plan(val type: String, var id: Int = 0) {
    open fun getValue(rent: Rent): Double {
        return rent.game.preco * rent.period.inDays
    }
}