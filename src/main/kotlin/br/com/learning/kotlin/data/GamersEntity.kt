package br.com.learning.kotlin.data

import javax.persistence.*

@Entity
@Table(name = "gamers")
class GamersEntity(
    val name: String = "Nome do gamer",
    val email: String = "Email do gamer",
    val dateOfBirth: String? = "Data de nascimento do gamer",
    val user: String? = "user do gamer",
    @ManyToOne
    val plan: PlanEntity = DefaultPlanEntity(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}