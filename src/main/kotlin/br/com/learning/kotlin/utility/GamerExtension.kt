package br.com.learning.kotlin.utility

import br.com.learning.kotlin.data.GamersEntity
import br.com.learning.kotlin.model.Gamer
import br.com.learning.kotlin.model.InfoGamerJson

fun InfoGamerJson.transformGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}

fun Gamer.toEntity(): GamersEntity {
    return GamersEntity(this.name, this.email, this.dateOfBirth, this.user, this.plan.toEntity(), this.id)
}

fun GamersEntity.toModel(): Gamer {
    return Gamer(this.name, this.email, this.dateOfBirth, this.user, this.id)
}