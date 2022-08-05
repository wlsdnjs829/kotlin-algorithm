package com.example.kotlinalgorithm.level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
class 신규_아이디_추천 {

    fun solution(new_id: String) = new_id.lowercase()
            .filter { it in 'a'..'z' || it in '0'..'9' || it in "-_." }
            .replace(Regex("""\.+"""), ".")
            .removePrefix(".")
            .removeSuffix(".")
            .run { ifEmpty { "a" } }
            .take(15)
            .removeSuffix(".")
            .let {
                when (it.length) {
                    1 -> it.plus(it.last()).plus(it.last())
                    2 -> it.plus(it.last())
                    else -> it
                }
            }

}



