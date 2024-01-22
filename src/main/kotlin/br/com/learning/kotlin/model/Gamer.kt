package br.com.learning.kotlin.model

import java.util.*
import kotlin.random.Random

data class Gamer(val name: String, var email: String) : Recommended {
    var dateOfBirth: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (user.isNullOrBlank()) {
                createHashId()
            }
        }
    var internalId: String? = null
        private set

    val listGames = mutableListOf<Game?>()
    val listRents = mutableListOf<Rent>()
    private val listPoints = mutableListOf<Int>()
    var plan: Plan = DefaultPlan("BRONZE")

    constructor(name: String, email: String, dateOfBirth: String, user: String)
            : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.user = user
        createHashId()
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("O nome não pode ser aceito!")
        }
        this.email = validateEmail()
    }

    private fun createHashId() {
        val randomId = Random.nextInt(100000)
        val hashId = String.format("%05d", randomId)

        internalId = "$user#$hashId"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("O email não pode ser aceito!")
        }
    }

    companion object {
        fun createGamer(scanner: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = scanner.nextLine()
            println("Digite seu e-mail:")
            val email = scanner.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? S/N")
            val option = scanner.nextLine()

            if (option.equals("s", true)) {
                println("Digite sua data de nascimento (DD/MM/AAAA):")
                val dateOfBirth = scanner.nextLine()
                println("Digite seu nome de usuário:")
                val user = scanner.nextLine()

                return Gamer(name, email, dateOfBirth, user)
            } else {
                return Gamer(name, email)
            }
        }
    }

    fun rentGame(game: GameJson, period: PeriodRent): Rent {
        val rent = Rent(this, game, period)
        listRents.add(rent)

        return rent
    }

    fun gamesInMonth(month: Int): List<GameJson> {
        return listRents
            .filter { rent -> rent.period.startDate.monthValue == month }
            .map { rent -> rent.game }
    }

    override val avg: Double
        get() = listPoints.average()

    override fun recommend(point: Int) {
        if (point < 1 || point > 10) {
            println("Nota inválida. Insira uma nota entre 1 e 10")
        }
        listPoints.add(point)
    }

    override fun toString(): String {
        return "Gamer: \n" +
                "Name='$name', \n" +
                "Email='$email', \n" +
                "DateOfBirth=$dateOfBirth, \n" +
                "User=$user, \n" +
                "InternalId=$internalId \n" +
                "Média=$avg"
    }
}
