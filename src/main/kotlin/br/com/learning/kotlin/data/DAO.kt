package br.com.learning.kotlin.data

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(
    protected val manager: EntityManager,
    protected val entityType: Class<TEntity>
) {
    abstract fun toEntity(obj: TModel): TEntity
    abstract fun toModel(obj: TEntity): TModel

    open fun getList(): List<TModel> {
        val query = manager.createQuery("from ${entityType.simpleName}", entityType)
        return query.resultList.map { entity ->
            toModel(entity)
        }
    }

    open fun findForId(id: Int): TModel {
        val obj = manager.createQuery("from ${entityType.simpleName} where id = :id", entityType)
            .setParameter("id", id)
            .singleResult

        return toModel(obj)
    }

    open fun create(data: TModel) {
        val entity = toEntity(data)

        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun deleteData(id: Int) {
        try {
            val obj = manager.createQuery("from ${entityType.simpleName} where id = :id", entityType)
                .setParameter("id", id)
                .singleResult

            manager.transaction.begin()
            manager.remove(obj)
            manager.transaction.commit()
        } catch (e: Exception) {
            println("O id informado não existe")
        }
    }
}