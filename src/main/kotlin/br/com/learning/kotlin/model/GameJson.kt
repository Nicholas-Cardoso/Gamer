package br.com.learning.kotlin.model

data class GameJson(
    val titulo: String,
    val capa: String
) {
    var descricao: String? = null
    var preco: Double = 0.0

    constructor(
        titulo: String,
        capa: String,
        descricao: String,
        preco: Double
    ) : this(titulo, capa) {
        this.descricao = descricao
        this.preco = preco
    }

    override fun toString(): String {
        return "Game: \n" +
                "Title: $titulo \n" +
                "Thumb: $capa \n" +
                "Description: $descricao \n" +
                "Price: $preco"
    }
}