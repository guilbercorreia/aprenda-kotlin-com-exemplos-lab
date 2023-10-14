import java.lang.IllegalArgumentException
import java.util.ArrayList
import java.util.Scanner

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

enum class Formacoes {Kotlin}

data class Usuario (val nome: String, val especialidade: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val Nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} inscrito com sucesso na $nome")
    }
}

fun main() {

    val introducaoKotlin = ConteudoEducacional("Introdução prática à linguaguem Kotlin", 30, Nivel.BASICO)
    val controleFluxoKotlin = ConteudoEducacional("Estruturas de controle de fluxo no Kotlin", Nivel = Nivel.BASICO)
    val funcoesKotlin = ConteudoEducacional("O poder das funções em Kotlin", Nivel = Nivel.BASICO)
    val tratamentoExcecoesKotlin = ConteudoEducacional("Tratamento de exceções em Kotlin", Nivel = Nivel.INTERMEDIARIO)
    val kotlin = Formacao("Formação Kotlin", listOf(introducaoKotlin, controleFluxoKotlin, funcoesKotlin, tratamentoExcecoesKotlin))

    val formacoesdisponiveis = ArrayList<Formacoes>()
    formacoesdisponiveis.add(Formacoes.Kotlin)

    println("Aqui está uma lista das formações disponiveis: $formacoesdisponiveis")
    val sc = Scanner(System.`in`)

    println("Qual seu nome?")
    val nome = sc.next()

    println("Qual sua especialização?")
    val spec = sc.next()
    val usuario = Usuario(nome, spec)

    println("Qual formação voce deseja se inscrever?")
    val formacao: String = sc.next().uppercase()

    if (formacao == "KOTLIN"){
         kotlin.matricular(usuario)
    }
    else throw IllegalArgumentException("Formação desconhecida")

    sc.close()

}