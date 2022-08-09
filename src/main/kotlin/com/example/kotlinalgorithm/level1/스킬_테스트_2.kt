package com.example.kotlinalgorithm.level1

/**
 * https://programmers.co.kr/skill_checks/406246?challenge_id=7418
 */
class 스킬_테스트_2 {
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
