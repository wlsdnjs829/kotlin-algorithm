package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
class 오픈채팅방 {

    private val map = mutableMapOf<String, String>()

    fun solution(record: Array<String>) =
        record.mapNotNull(::printMessage)
            .map { log ->
                val keyValue = log.split('#')
                val key = keyValue[0]
                val value = keyValue[1]
                map[key] + value
            }

    private fun printMessage(log: String): String? {
        val logData = log.split(" ")

        val code = logData[0]
        val id = logData[1]

        return when (code) {
            "Enter" -> {
                map[id] = logData[2]
                "$id#님이 들어왔습니다."
            }
            "Leave" -> "$id#님이 나갔습니다."
            else -> {
                map[id] = logData[2]
                null
            }
        }
    }

}
