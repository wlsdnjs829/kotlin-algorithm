package com.example.kotlinalgorithm.이분탐색

fun main() {
    println(입국_심사_L3().solution(6, intArrayOf(7, 10)))
}

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=kotlin
 */
class 입국_심사_L3 {

    fun solution(n: Int, times: IntArray): Long {
        var min: Long = n.toLong() / times.size * times.minOf { it }.toLong()
        var max: Long = times.maxOf { it }.toLong() * n

        while (min <= max) {
            val mid = (min + max) / 2

            var sum: Long = 0
            times.forEach { sum += mid / it }

            if (sum >= n) max = mid - 1 else min = mid + 1
        }

        return max + 1
    }

}
