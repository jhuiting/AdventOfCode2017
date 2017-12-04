package day4

import util.InputUtils

class PasswordPolicySolver {
    companion object {
        fun solvePart1(input: List<List<String>>) {
            val uniquePasswordsCount = input.filter { it.distinct().count() == it.size }.count()
            println("Solution password duplication part 1: $uniquePasswordsCount")
        }

        fun solvePart2(input: List<List<String>>) {
            val sortedPasswords = input.map { it.map{ it.toSortedSet() }  }
            val uniquePasswordsCount = sortedPasswords.filter { it.distinct().count() == it.size }.count()
            println("Solution password duplication part 2: $uniquePasswordsCount")
        }
    }
}


fun main(args : Array<String>) {
    val inputLists = InputUtils.getInputAsLineArray("day4")
            .map{ it.split(" ") }

    PasswordPolicySolver.solvePart1(inputLists)
    PasswordPolicySolver.solvePart2(inputLists)
}