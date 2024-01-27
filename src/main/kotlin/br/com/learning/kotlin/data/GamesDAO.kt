package br.com.learning.kotlin.data

import br.com.learning.kotlin.model.GameJson
import toEntity
import toModel
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager) : DAO<GameJson, GamesEntity>(manager, GamesEntity::class.java) {
    override fun toEntity(obj: GameJson): GamesEntity {
        return obj.toEntity()
    }

    override fun toModel(obj: GamesEntity): GameJson {
        return obj.toModel()
    }
}