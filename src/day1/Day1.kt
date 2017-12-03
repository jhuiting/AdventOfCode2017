package day1

import util.InputUtils

class CaptchaSolver {
    companion object {
        fun solvePart1(input: List<Int>) {
            val totalCount = input.indices
                    .filter { it != 0 }
                    .map {
                        when {
                            it == input.size - 1 && input[0] == input[it] -> input[it]
                            input[it - 1] == input[it] -> input[it]
                            else -> 0
                        }
                    }
                    .sum()

            println("Solution captcha part 1: $totalCount")
        }

        fun solvePart2(input: List<Int>) {
            val halfListSize = input.size / 2
            val totalCount = input.indices
                    .map {
                        when {
                            it < halfListSize && input[it] == input[it + halfListSize] -> input[it] + input[it + halfListSize]
                            else -> 0
                        }
                    }
                    .sum()

            println("Solution captcha part 2: $totalCount")
        }
    }
}

fun main(args : Array<String>) {
    val captchaList = InputUtils.getInputAsString("day1")
                        .split("")
                        .filter { it != "" }
                        .map { it.toInt() }

    CaptchaSolver.solvePart1(captchaList)
    CaptchaSolver.solvePart2(captchaList)
}