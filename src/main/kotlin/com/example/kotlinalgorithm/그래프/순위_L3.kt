package com.example.kotlinalgorithm.그래프

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=kotlin
 */
class 순위_L3 {

    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val check = Array(n  + 1) {
            BooleanArray(n + 1)
        }

        results.forEach { (winner, looser) ->
            check[winner][looser] = true
        }

        for (mid in 1..n) {
            for (start in 1..n) {
                for (end in 1..n) {
                    if (check[start][mid] && check[mid][end])
                        check[start][end] = true
                }
            }
        }

        for (from in 1..n) {
            var cnt = 0
            for (to in 1..n) {
                if (check[from][to] || check[to][from]) cnt++
            }
            if (cnt == n - 1) answer++
        }

        return answer
    }

}