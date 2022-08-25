package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
class 카펫 {

    fun solution(brown: Int, yellow: Int) =
        (1..yellow).first { (yellow % it == 0) && ((yellow / it + it) * 2 + 4 == brown) }
            .run { intArrayOf(yellow / this + 2, this + 2) }

}
