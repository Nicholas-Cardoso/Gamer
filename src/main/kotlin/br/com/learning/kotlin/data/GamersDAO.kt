package br.com.learning.kotlin.data

import br.com.learning.kotlin.model.Gamer
import br.com.learning.kotlin.utility.toEntity
import br.com.learning.kotlin.utility.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager) : DAO<Gamer, GamersEntity>(manager, GamersEntity::class.java) {
    override fun toEntity(obj: Gamer): GamersEntity {
//        return GamersEntity(obj.name, obj.email, obj.dateOfBirth, obj.user, obj.plan.toEntity(), obj.id)
        return obj.toEntity()
    }

    override fun toModel(obj: GamersEntity): Gamer {
//        return Gamer(obj.name, obj.email, obj.dateOfBirth, obj.user, obj.id)
        return obj.toModel()
    }
}