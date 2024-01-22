package br.com.learning.kotlin.utility

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