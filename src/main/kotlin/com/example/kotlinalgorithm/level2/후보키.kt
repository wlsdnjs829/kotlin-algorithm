package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42890
 */
class 후보키 {

    private var size = 0
    private val keySets = mutableListOf<Int>()

    fun solution(relation: Array<Array<String>>): Int {
        val row = relation.find { it.isNotEmpty() }
        size = row?.size ?: 0

        (1 until (1 shl size))
            .filter { isUnique(relation, it) }
            .forEach { index -> if (keySets.none { it and index == it }) keySets.add(index) }

        return keySets.size
    }

    private fun isUnique(relation: Array<Array<String>>, index: Int): Boolean {
        val bitIndex = (0 until size)
            .filter { index and (1 shl it) != 0 }
            .toList()

        val bitIndexJoinSet = relation
            .map { tuple -> bitIndex.joinToString { tuple[it] } }
            .toSet()

        return relation.size == bitIndexJoinSet.size
    }

}
