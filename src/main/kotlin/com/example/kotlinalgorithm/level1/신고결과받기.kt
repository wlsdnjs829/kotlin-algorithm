package com.example.kotlinalgorithm.level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=kotlin
 */
class Solution {

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
            report.asSequence()
                    .map { it.split(" ") }
                    .groupBy{ it.last() }
                    .map { it.value.distinct() }
                    .filter { it.size >= k }
                    .flatten()
                    .groupingBy { it.first() }
                    .eachCount()
                    .run { id_list.map { getOrElse(it) {0} }.toIntArray() }

/*
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportMap = hashMapOf<String, MutableSet<String>>()

        for (reportInfo in report) {
            val reportTarget = reportInfo.split(" ")

            val reporter = reportTarget[0]
            val target = reportTarget[1]

            val reportSet = reportMap.getOrPut(target) { mutableSetOf() }
            reportSet.add(reporter)
        }

        val noticeMap = hashMapOf<String, Int>()

        for (id in id_list) {
            val target = reportMap.getOrElse(id) { setOf() }

            if (target.size < k) {
                continue
            }

            target.forEach { reportId -> addNoticeCount(noticeMap, reportId) }
        }

        val answer = IntArray(id_list.size)

        for (index in id_list.indices) {
            val noticeCount = noticeMap.getOrElse(id_list[index]) { 0 }
            answer[index] = noticeCount
        }

        return answer
    }

    private fun addNoticeCount(noticeMap: HashMap<String, Int>, reportId: String) {
        val noticeCount = noticeMap.getOrPut(reportId) { 0 }
        noticeMap[reportId] = noticeCount.inc()
    }
*/

}

