package com.example.kotlinalgorithm.level2

import java.lang.Integer.min

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
class 문자열_압축 {

    fun solution(s: String): Int {
        val length = s.length
        val half = length / 2

        val converts = IntArray(half)

        for (unit: Int in 1..half) {
            converts[unit - 1] = s.convert(unit, 0)
        }

        if (converts.isEmpty()) {
            return s.length
        }

        return converts.minOf { i: Int -> i }
    }

    private fun String.convert(unit: Int, current: Int): Int {
        var convert = 0

        val endIndex = current + unit
        val targetEndIndex = endIndex + unit

        if (targetEndIndex > this.length) {
            convert += (length - current)
            return convert
        }

        val word = this.substring(current, endIndex)
        val target = this.substring(endIndex, targetEndIndex)

        if (word != target) {
            convert += word.length
            return convert + convert(unit, endIndex)
        }

        convert += word.length + 1

        val judgmentCurrent = this.judgment(unit, endIndex, word)

        val sameIndex = (judgmentCurrent - current) / unit

        if (sameIndex > 9) {
            convert += 1
        }

        if (sameIndex > 99) {
            convert += 1
        }

        return convert + convert(unit, judgmentCurrent)
    }

    private fun String.judgment(unit: Int, current: Int, word: String): Int {
        val endIndex = current + unit

        if (endIndex > this.length) {
            return current
        }

        val target = this.substring(current, endIndex)

        if (word == target) {
            return this.judgment(unit, endIndex, word)
        }

        return current
    }

    fun anotherSolution(s: String): Int {
        var answer = s.length
        val len = s.length / 2

        for (i in 1..len) {
            val t = s.substring(0 until i)
            answer = min(answer, count(t, s, 0, 0))
        }

        return answer
    }

    private fun count(t: String, s: String, cur: Int, sum: Int): Int {
        var len = cur.toString().length + t.length

        if (cur == 1) {
            --len
        }

        if (s.length < t.length) {
            return sum + len + s.length
        }

        if (s.startsWith(t)) {
            return count(t, s.substring(t.length), cur + 1, sum)
        }

        return count(s.substring(0, t.length), s, 0, sum + len)
    }

}
