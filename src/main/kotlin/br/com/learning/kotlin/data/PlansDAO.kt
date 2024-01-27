package br.com.learning.kotlin.data

import br.com.learning.kotlin.model.Plan
import br.com.learning.kotlin.utility.toEntity
import br.com.learning.kotlin.utility.toModel
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(obj: Plan): PlanEntity {
        return obj.toEntity()
    }

    override fun toModel(obj: PlanEntity): Plan {
        return obj.toModel()
    }
}