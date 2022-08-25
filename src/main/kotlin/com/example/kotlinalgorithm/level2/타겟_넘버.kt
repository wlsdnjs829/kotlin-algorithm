package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
class 타겟_넘버 {

    fun solution(numbers: IntArray, target: Int) = target.dfs(0, numbers, IntArray(numbers.size))

    private fun Int.dfs(index: Int, numbers: IntArray, case: IntArray): Int =
        when {
            numbers.size != index -> {
                case[index] = numbers[index]

                val minusCase = case.copyOf()
                minusCase[index] *= -1

                dfs(index + 1, numbers, minusCase) + dfs(index + 1, numbers, case)
            }
            this == case.sum() -> 1
            else -> 0
        }

    class Solution {
        fun solution(numbers: IntArray, target: Int): Int =
            numbers.fold(listOf<Int>()) { list, i ->
                list.run {
                    map { it + i } + map { it - i }
                }
            }.count { it == target }
    }

}
