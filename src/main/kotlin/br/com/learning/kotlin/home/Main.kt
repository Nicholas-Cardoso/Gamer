package br.com.learning.kotlin.home

import br.com.learning.kotlin.model.Game
import br.com.learning.kotlin.model.Gamer
import br.com.learning.kotlin.services.UseAPI
import formatterDateOfBirth
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val gamer = Gamer.createGamer(scanner)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)
    println("Sua idade: ${gamer.dateOfBirth?.formatterDateOfBirth()}")

    do {
        println("Digite o ID do game que procura: ")

        val id = scanner.nextInt()

        val searchApi = UseAPI()
        val infoGames = searchApi.searchGame(id)

        var myGames: Game? = null
        val result = runCatching {
            myGames = Game(
                infoGames.info.title,
                infoGames.info.thumb
            )
        }

        result.onFailure {
            println("O Id $id não foi encontrado")
        }

        result.onSuccess {
            println("--------------------------------------------------------------")
            println(myGames)
            println("--------------------------------------------------------------")
            val input = Scanner(System.`in`)
            println("Deseja inserir uma descrição personalizada? S/N")
            val option = input.nextLine()

            if (option.equals("s", true)) {
                println("Insira a descrição personalizada para o jogo: ")
                val description = input.nextLine()

                myGames?.description = description

                gamer.listGames.add(myGames)
            } else {
                myGames?.description = myGames?.title

                gamer.listGames.add(myGames)
            }
        }

        println("Deseja buscar outro game? S/N")

        val choose = Scanner(System.`in`)
        val research = choose.nextLine()
    } while (research.equals("s", true))

    gamer.listGames.sortBy {
        it?.title
    }
    gamer.listGames.forEach {
        println("Título: ${it?.title}")
        println("--------------------------------------------------------------")
    }

    val question = Scanner(System.`in`)
    println("Na sua lista de jogos, você deseja filtrar algum jogo? S/N")
    val answer = question.nextLine()

    if (answer.equals("s", true)) {
        println("Qual jogo você quer filtrar? ")
        val filter = question.nextLine()

        val filterGames = gamer.listGames.filter {
            it?.title?.contains(filter, true) ?: false
        }
        println(filterGames)
    }

    println("Deseja excluir algum jogo da sua lista? S/N")
    val removeAt = question.nextLine()

    if (removeAt.equals("s", true)) {
        do {
            println("Insira o título do jogo a ser excluído: ")
            val gameAsRemove = question.nextLine()

            val filter = gamer.listGames.filter {
                it?.title?.contains(gameAsRemove, true) ?: false
            }
            if (filter.equals(false)) {
                println("O título do game não foi encontrado")
            }

            val gameDeleted = gamer.listGames.indexOf(filter[0])
            gamer.listGames.removeAt(gameDeleted)

            println("Jogo removido com sucesso!")
            println(gamer.listGames)
            println("Deseja excluir outro jogo? S/N")
            val otherGameAsRemove = question.nextLine()
        } while (otherGameAsRemove.equals("s", true))
    }

    println("Aplicação encerrada")
}