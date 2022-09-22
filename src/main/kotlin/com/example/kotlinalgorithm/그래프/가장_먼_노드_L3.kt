package com.example.kotlinalgorithm.그래프

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=kotlin
 */
class 가장_먼_노드_L3 {

    private val removeNode = mutableSetOf<Int>()

    fun solution(n: Int, edge: Array<IntArray>) =
            edge.flatMap { setOf(it[0] to it[1], it[1] to it[0]) }
                    .groupBy { it.first }
                    .map { entry -> entry.key to entry.value.map { it.second }.toSet() }
                    .toMap()
                    .run {
                        val values = setOf(1)
                        removeNode.add(1)
                        depth(this, values)
                    }

    private tailrec fun depth(map: Map<Int, Set<Int>>, values: Set<Int>): Int {
        val otherDepth = map.filterKeys { values.contains(it) }
                .values
                .flatMap { it.toMutableList() }
                .filter { !values.contains(it) && !removeNode.contains(it) }
                .toSet()

        return if (otherDepth.isEmpty()) {
            values.size
        } else {
            removeNode.addAll(otherDepth)
            depth(map, otherDepth.toSet())
        }
    }

}
