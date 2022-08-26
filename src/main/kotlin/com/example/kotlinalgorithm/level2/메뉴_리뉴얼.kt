package com.example.kotlinalgorithm.level2

fun main() {
    val message = 메뉴_리뉴얼().solution(arrayOf("ABCVFERTGYHUJEDIKWS", "ABCVFERTGYHUJEDIKWS", "ABCVFERTGYHUJEDIKWS", "ABCVFERTGYHUJEDIKWS", "ABCVFERTGYHUJEDIKWS", "ABCVFERTGYHUJEDIKWS", "ABCVFERTGYHUJEDIKWS"), intArrayOf(10))
    println(message)
}

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
class 메뉴_리뉴얼 {

    fun solution(orders: Array<String>, course: IntArray): Array<String> =
        course.flatMap {
            val renewal = mutableListOf<String>()
            combine(renewal, orders, Array(20) { false }, 0, it)

            val menus = renewal.map { menu -> String(menu.toCharArray().apply { sort() }) }
                .groupingBy { menu -> menu }
                .eachCount()

            val maxOf = menus.maxOfOrNull { entry -> entry.value }

            menus.filter { menu -> maxOf != 1 && maxOf == menu.value }
                .map { menu -> menu.key }
                .toList()
        }.sorted().toTypedArray()

    private fun combine(
        answer: MutableList<String>, target: Array<String>, visited: Array<Boolean>, start: Int, count: Int
    ) {
        if (count == 0) {
            answer.addAll(
                target.map { it.filterIndexed { index, _ -> visited[index] } }
                    .filter { combineString -> combineString.length == visited.count { visit -> visit } })
            return
        }

        for (index in start until 10) {
            visited[index] = true
            combine(answer, target, visited, index + 1, count - 1)
            visited[index] = false
        }
    }

}
