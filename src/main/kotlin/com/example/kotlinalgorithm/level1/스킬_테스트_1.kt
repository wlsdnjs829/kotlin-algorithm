package com.example.kotlinalgorithm.level1

/**
 * https://programmers.co.kr/skill_checks/406246
 */
class 스킬_테스트_1 {
    fun solution(arr: IntArray, divisor: Int) =
        arr.filter { it % divisor == 0 }
            .sorted()
            .ifEmpty { intArrayOf(-1) }
}
