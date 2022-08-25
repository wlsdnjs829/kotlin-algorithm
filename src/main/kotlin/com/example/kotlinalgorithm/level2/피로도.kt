package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
class 피로도 {

    private var clears = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        dungeons.bf(k, mutableListOf(), 0)
        return clears
    }

    private fun Array<IntArray>.bf(k: Int, visited: MutableList<Int>, count: Int) {
        if (visited.size != this.size) {
            this.indices
                .filter { !visited.contains(it) }
                .forEach {
                    val copyVisited = visited.toMutableList()
                    copyVisited.add(it)
                    if (k >= this[it][0]) bf(k - this[it][1], copyVisited, count + 1)
                }
        }

        if (clears < count) {
            clears = count
        }
    }

}
