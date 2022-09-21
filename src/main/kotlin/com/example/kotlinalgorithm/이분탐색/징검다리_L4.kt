package com.example.kotlinalgorithm.이분탐색

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */
class 징검다리_L4 {

    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var min = 0
        var max = distance

        rocks.sort()

        while (min <= max) {
            val mid = (min + max) / 2

            var prev = 0
            var removeStone = 0

            for (index in rocks.indices) {
                if (rocks[index] - prev < mid) removeStone++ else prev = rocks[index]
            }

            if (distance - prev < mid) removeStone++

            if (removeStone <= n) min = mid + 1 else max = mid - 1
        }

        return min - 1
    }

}
