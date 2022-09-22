package com.example.kotlinalgorithm.깊이_너비_우선_탐색

fun main() {
    println(단어변환_L3().solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")))
}

/** https://school.programmers.co.kr/learn/courses/30/lessons/43163 */
class 단어변환_L3 {

    fun solution(begin: String, target: String, words: Array<String>): Int {
        val visited = BooleanArray(begin.length) { false }

        target.toCharArray()
            .forEachIndexed { index, char -> if (begin[index] == char) visited[index] = true }

        return words.map {
            it.toCharArray()
                .mapIndexed { index, char -> target[index] == char }
                .run {
                    it to this.count { b -> b }
                }
        }.filter { it.second != 0 }
            .sortedBy { pair -> pair.second }
            .map {
                it.first.toCharArray()
                    .mapIndexed { index, char ->
                        if (target[index] == char && !visited[index]) {
                            visited[index] = true
                            return@map 1
                        } else {
                            return@mapIndexed
                        }
                    }

                return@map 0
            }.sum()
            .run { if (visited.all { it }) this else 0 }
    }

}
