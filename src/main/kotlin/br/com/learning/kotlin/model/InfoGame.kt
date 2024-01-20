package br.com.learning.kotlin.model

data class InfoGame(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}