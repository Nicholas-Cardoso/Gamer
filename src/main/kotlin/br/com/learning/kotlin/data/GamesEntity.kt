package br.com.learning.kotlin.data

import javax.persistence.*

@Entity
@Table(name = "jogos")
class GamesEntity(
    val titulo: String = "Título do game",
    val capa: String = "Capa do game",
    val descricao: String? = null,
    val preco: Double = 0.0,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}