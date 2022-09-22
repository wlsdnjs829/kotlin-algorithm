package com.example.kotlinalgorithm.그래프

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=kotlin
 */
class 순위_L3 {

    fun solution(n: Int, results: Array<IntArray>): Int {
        val loseCase = results.map { it[1] to it[0] }
            .groupBy { it.first }
            .mapValues { pair -> pair.value.map { it.second } }

        return results.map { it[0] to it[1] }
            .groupBy { it.first }
            .mapValues { pair -> pair.value.map { it.second } }
            .toMutableMap()
            .run {
                (1..n).filter { this[it] == null }
                    .forEach { this[it] = listOf() }

                this.map {
                    val visited = BooleanArray(n) { false }
                    visited[it.key - 1] = true
                    it.value.forEach { value -> visited[value - 1] = true }

                    val connect = loseCase.dfs(it.key, visited)

                    it.value.forEach { value -> this.dfs(value, visited) }

                    if (visited.count { boolean -> boolean } == n) 1 else 0
                }.sum()
            }
    }

    private fun Map<Int, List<Int>>.dfs(value: Int, visited: BooleanArray) {
        return if (this[value]?.isNotEmpty() != true || this[value]?.all { visited[it - 1] } == true) {
            return
        } else {
            val nodes = this[value]!!
            nodes.filter { !visited[it - 1] }.forEach {
                visited[it - 1] = true
                dfs(it, visited)
            }
        }
    }

}