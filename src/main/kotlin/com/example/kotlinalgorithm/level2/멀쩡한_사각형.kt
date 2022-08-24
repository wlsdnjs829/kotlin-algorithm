package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048?language=kotlin
 */
class 멀쩡한_사각형 {

    fun solution(w: Int, h: Int): Long = w.toLong() * h.toLong() - (w + h - gcd(w, h))

    private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

}
