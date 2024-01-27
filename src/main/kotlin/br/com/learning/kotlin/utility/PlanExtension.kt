package br.com.learning.kotlin.utility

import br.com.learning.kotlin.data.DefaultPlanEntity
import br.com.learning.kotlin.data.PlanEntity
import br.com.learning.kotlin.data.SubPlanEntity
import br.com.learning.kotlin.model.DefaultPlan
import br.com.learning.kotlin.model.Plan
import br.com.learning.kotlin.model.SubPlan

fun Plan.toEntity(): PlanEntity {
    return if (this is SubPlan) {
        SubPlanEntity(this.type, this.monthlyPay, this.quantityGames, this.valueDiscount, this.id)
    } else {
        DefaultPlanEntity(this.type, this.id)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is SubPlanEntity) {
        SubPlan(this.type, this.monthlyPay, this.quantityGames, this.valueDiscount, this.id)
    } else {
        DefaultPlan(this.type, this.id)
    }
}