package com.example.kotlinalgorithm.level2

import kotlin.math.ceil

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
class 기능개발 {

    var minDays = 0

    fun solution(progresses: IntArray, speeds: IntArray) =
        progresses.mapIndexed { index, i ->
            val days = ceil(((100 - i).toDouble() / speeds[index])).toInt()

            if (minDays > days) {
                return@mapIndexed minDays
            }

            minDays = days
            return@mapIndexed days
        }
            .groupingBy { it }
            .eachCount()
            .toSortedMap()
            .values

}
