import br.com.learning.kotlin.data.GamesEntity
import br.com.learning.kotlin.model.GameJson
import br.com.learning.kotlin.model.InfoGameJson

fun InfoGameJson.transformGame (): GameJson {
    return GameJson (
        this.titulo,
        this.capa,
        this.descricao,
        this.preco,
        this.id
    )
}

fun GameJson.toEntity(): GamesEntity {
    return GamesEntity(this.titulo, this.capa, this.descricao, this.preco, this.id)
}

fun GamesEntity.toModel(): GameJson {
    return GameJson(this.titulo, this.capa, this.descricao, this.preco, this.id)
}