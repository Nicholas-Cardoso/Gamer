package br.com.learning.kotlin.data

import br.com.learning.kotlin.model.Rent
import br.com.learning.kotlin.utility.toEntity
import br.com.learning.kotlin.utility.toModel
import toEntity
import toModel
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager) : DAO<Rent, RentEntity>(manager, RentEntity::class.java) {
    override fun toEntity(obj: Rent): RentEntity {
        return RentEntity(obj.gamer.toEntity(), obj.game.toEntity(), obj.period)
            .apply {
                valueRent = obj.rentValue
                id = obj.id
            }
    }

    override fun toModel(obj: RentEntity): Rent {
        return Rent(obj.gamer.toModel(), obj.game.toModel(), obj.period)
            .apply {
                id = obj.id
            }
    }
}