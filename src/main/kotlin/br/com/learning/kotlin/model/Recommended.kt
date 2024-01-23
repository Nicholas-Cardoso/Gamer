package br.com.learning.kotlin.model

interface Recommended {
    val avg: Double

    fun recommend(point: Int) {
    }
}