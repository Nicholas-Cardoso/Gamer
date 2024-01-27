package br.com.learning.kotlin.model

data class Game(
    var title: String,
    var thumb: String,
    var description: String? = ""
) {
    override fun toString(): String {
        return "Título='$title', \n" +
                "Capa='$thumb', \n" +
                "Descrição='$description', \n"
    }
}