package day2

import util.InputUtils

class SpreadSheetSolver {
    companion object {
        fun solvePart1(input: List<List<Int>>) {
            val checkSum = input.map { it.max()!! - it.min()!! }.sum()
            println("Solution spreadsheet part 1: $checkSum")
        }

        fun solvePart2(input: List<List<Int>>) {
            val checkSumInput = input
                .map { it.sorted().chunked(it.size / 2) } // Split the input in 2 sorted groups
                .flatMap {
                    // Check modulo for each "high" number and calculate division result
                    it[1].flatMap { highNumber ->
                        it[0].map { lowNumber -> when {
                                highNumber % lowNumber == 0 -> highNumber / lowNumber
                                else -> 0
                            }
                        }
                    }
                }.sum()

            println("Solution spreadsheet part 2: $checkSumInput")

        }
    }
}

fun main(args : Array<String>) {
    val inputLists = InputUtils.getInputAsLineArray("day2")
            .map { it.split("\t") }
            .map { it.map{ it.toInt() } }

    SpreadSheetSolver.solvePart1(inputLists)
    SpreadSheetSolver.solvePart2(inputLists)
}