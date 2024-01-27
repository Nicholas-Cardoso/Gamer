package br.com.learning.kotlin.data

import javax.persistence.*

@Entity
@Table(name = "plano")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypePlan", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val type: String,
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    val id: Int = 0
)

@Entity
@DiscriminatorValue("Default")
class DefaultPlanEntity(type: String = "Plano avulso", id: Int = 0) : PlanEntity(type, id)

@Entity
@DiscriminatorValue("SubPlan")
class SubPlanEntity(
    type: String = "Plano assinatura",
    val monthlyPay: Double = 0.0,
    val quantityGames: Int = 0,
    val valueDiscount: Double = 0.0,
    id: Int = 0
) : PlanEntity(type, id)