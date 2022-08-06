package com.example.kotlinalgorithm.level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=kotlin
 */
class 숫자_문자열과_영단어 {
    fun solution(s: String) = s.wordToDigit()
}

private fun String.wordToDigit(): Int {
    val wordMap = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    var convert = this

    for ((index, word) in wordMap.withIndex()) {
        convert = convert.replace(word, index.toString())
    }

    return convert.toInt()
}
