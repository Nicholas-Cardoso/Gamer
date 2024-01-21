package br.com.learning.kotlin.model

import java.util.*
import kotlin.random.Random

data class Gamer(val name: String, var email: String) {
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

    private fun validateEmail (): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("O email não pode ser aceito!")
        }
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth=$dateOfBirth, user=$user, internalId=$internalId)"
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
            } else { return Gamer(name, email) }
        }
    }
}
