package com.example.kotlinalgorithm.level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 */
class 로또의_최고_순위와_최저_순위 {

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val joker = lottos.count { it == 0 }

        val containsCount = lottos.count { win_nums.contains(it) }

        val topRank = getRank(containsCount + joker)
        val lowestRank = getRank(containsCount)

        return intArrayOf(topRank, lowestRank)
    }

    private fun getRank(containsCount: Int) = when (containsCount) {
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }

}



