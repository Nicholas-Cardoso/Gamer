package br.com.learning.kotlin.data

import br.com.learning.kotlin.model.PeriodRent
import javax.persistence.*

@Entity
@Table(name = "rent")
class RentEntity(
    @ManyToOne
    val gamer: GamersEntity = GamersEntity(),
    @ManyToOne
    val game: GamesEntity = GamesEntity(),
    @Embedded
    val period: PeriodRent = PeriodRent()
) {
    var valueRent: Double = 0.0
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    var id: Int = 0
}