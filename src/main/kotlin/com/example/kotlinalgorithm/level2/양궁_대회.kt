package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */
class 양궁_대회 {

    private lateinit var maxArray: IntArray
    var maxScore: Int = 0

    private val maxIndex = 11

    fun solution(n: Int, info: IntArray): IntArray {
        dfs(IntArray(11), 0, n, info)

        if (maxScore < 1) {
            return intArrayOf(-1)
        }

        return maxArray
    }

    private fun dfs(case: IntArray, order: Int, n: Int, apeach: IntArray) {
        if (order == maxIndex) {
            choiceMaxCase(case, apeach)
            return
        }

        if (order == maxIndex - 1) {
            val copyCase = case.copyOf()
            copyCase[order] = n
            return dfs(copyCase, order + 1, 0, apeach)
        }

        val data = apeach[order]

        if (data >= n) {
            return dfs(case, order + 1, n, apeach)
        }

        dfs(case, order + 1, n, apeach)

        val result = data + 1

        val copyCase = case.copyOf()
        copyCase[order] = result

        dfs(copyCase, order + 1, n - result, apeach)
    }

    private fun choiceMaxCase(case: IntArray, apeach: IntArray) {
        val sum = case.mapIndexed { index, data ->
            if (data != 0) {
                10 - index
            } else if (apeach[index] != 0) {
                (10 - index).unaryMinus()
            } else 0
        }.sum()

        if (sum < 1 || maxScore > sum) {
            return
        }

        if (sum > maxScore) {
            maxScore = sum
            maxArray = case
            return
        }

        for (index in 10 downTo 0) {
            if (maxArray[index] < case[index]) {
                maxScore = sum
                maxArray = case
                return
            }

            if (maxArray[index] > case[index]) {
                return
            }
        }
    }

}
