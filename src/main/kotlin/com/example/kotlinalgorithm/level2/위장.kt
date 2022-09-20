package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
class 위장 {

    fun solution(clothes: Array<Array<String>>) =
        clothes.groupingBy { it[1] }
            .eachCount()
            .map { it.value + 1 }
            .reduce { total, index -> total * index } - 1

}