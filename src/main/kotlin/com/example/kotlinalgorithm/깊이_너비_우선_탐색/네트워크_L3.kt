package com.example.kotlinalgorithm.깊이_너비_우선_탐색

/** https://school.programmers.co.kr/learn/courses/30/lessons/43162 */
class 네트워크_L3 {

    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = BooleanArray(n) { false }

        return computers.mapIndexed { index, data ->
            if (visited[index]) {
                0
            } else {
                visited[index] = true

                for ((innerIndex, innerData) in data.withIndex()) {
                    if (innerData == 1) computers.dfs(visited, innerIndex)
                }

                1
            }
        }.sum()
    }

    private fun Array<IntArray>.dfs(visited: BooleanArray, index: Int) {
        if (visited[index]) {
            return
        }

        visited[index] = true
        val data = this[index]

        for ((innerIndex, innerData) in data.withIndex()) {
            if (innerData == 1) this.dfs(visited, innerIndex)
        }
    }

}
