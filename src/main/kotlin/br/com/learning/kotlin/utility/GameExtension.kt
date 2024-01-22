import br.com.learning.kotlin.model.GameJson
import br.com.learning.kotlin.model.InfoGameJson

fun InfoGameJson.transformGame (): GameJson {
    return GameJson (
        this.titulo,
        this.capa,
        this.descricao,
        this.preco
    )
}