package br.com.learning.kotlin.model

import br.com.learning.kotlin.utility.formatDoubleDecimal
import com.google.gson.annotations.Expose

data class GameJson(
    @Expose val titulo: String,
    @Expose val capa: String
) : Recommended {
    var descricao: String? = null
    var preco: Double = 0.0.formatDoubleDecimal()

    val listNotes = mutableListOf<Int>()

    override val avg: Double
        get() = listNotes.average().formatDoubleDecimal()

    constructor(
        titulo: String,
        capa: String,
        descricao: String,
        preco: Double
    ) : this(titulo, capa) {
        this.descricao = descricao
        this.preco = preco
    }

    override fun recommend(point: Int) {
        listNotes.add(point)
    }

    override fun toString(): String {
        return "Game: \n" +
                "Title: $titulo \n" +
                "Thumb: $capa \n" +
                "Description: $descricao \n" +
                "Price: $preco"
    }
}