package com.example.kotlinalgorithm.method

//fun main() {
//    val target = listOf(1, 2, 3)
//    println(순열().permutation(target))
//
//    val answer = mutableListOf<List<Int>>()
//    조합().combination(answer, target, Array(target.size) { false }, 0, 2)
//    println(answer)
//
//    val answerToString = mutableListOf<String>()
//    조합().combinationToString(answerToString, listOf("A", "B", "C", "D"), Array(4) { false }, 0, 3)
//    println(answerToString)
//
//    val combineString = mutableListOf<String>()
//    조합().combine(combineString, listOf("ABC", "BDF", "CSA", "ERS"), Array(3) { false }, 0, 3)
//    println(combineString)
//}

class 조합 {

    /* "A", "B" 와 같은 요소로 되어 있을 때 -> ["A", "B"], ["A", "C"] */
    fun <T> combination(
        answer: MutableList<List<T>>, target: List<T>, visited: Array<Boolean>, start: Int, count: Int
    ) {
        if (count == 0) {
            answer.addAll(listOf(target.filterIndexed { index, _ -> visited[index] }))
            return
        }

        for (index in start until target.size) {
            visited[index] = true
            combination(answer, target, visited, index + 1, count - 1)
            visited[index] = false
        }
    }

    /* "A", "B" 와 같은 요소로 되어 있을 때 -> "AB", "AC" */
    fun combinationToString(
        answer: MutableList<String>, target: List<String>, visited: Array<Boolean>, start: Int, count: Int
    ) {
        if (count == 0) {
            answer.addAll(listOf(target.filterIndexed { index, _ -> visited[index] }.joinToString("")))
            return
        }

        for (index in start until target.size) {
            visited[index] = true
            combinationToString(answer, target, visited, index + 1, count - 1)
            visited[index] = false
        }
    }

    /* "AB", "ABC" 와 같은 요소로 되어 있을 때 */
    fun combine(
        answer: MutableList<String>, target: List<String>, visited: Array<Boolean>, start: Int, count: Int
    ) {
        if (count == 0) {
            answer.addAll(
                target
                    .map { it.filterIndexed { index, _ -> visited[index] } }
                    .filter { combineString -> combineString.length == visited.count { visit -> visit } })
            return
        }

        for (index in start until visited.size) {
            visited[index] = true
            combine(answer, target, visited, index + 1, count - 1)
            visited[index] = false
        }
    }

}

class 순열 {

    fun <T> permutation(sub: List<T>, fin: List<T> = listOf()): List<List<T>> {
        return if (sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(sub - it, fin + it) }
    }

}