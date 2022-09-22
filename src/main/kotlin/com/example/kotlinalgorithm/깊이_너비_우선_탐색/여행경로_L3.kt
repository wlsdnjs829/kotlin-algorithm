package com.example.kotlinalgorithm.깊이_너비_우선_탐색

/** https://school.programmers.co.kr/learn/courses/30/lessons/43163 */
class 여행경로_L3 {

    fun solution(tickets: Array<Array<String>>): Array<String> {
        tickets.sortWith(compareBy({ it[0] }, { it[1] }))

        val startRoutes = tickets.mapIndexed { index, routes -> index to routes }
            .filter { it.second[0] == "ICN" }
            .sortedBy { it.second[1] }

        val routes = mutableListOf<String>()

        for (startRoute in startRoutes) {
            val visited = BooleanArray(tickets.size) { false }
            visited[startRoute.first] = true

            val dfs = tickets.dfs(0, startRoute.second[1], visited)
            if (dfs.size == tickets.size - 1) {
                routes.addAll(startRoute.second)
                routes.addAll(dfs)
                return routes.toTypedArray()
            }
        }

        return arrayOf()
    }

    private fun Array<Array<String>>.dfs(order: Int, route: String, visited: BooleanArray): MutableList<String> {
        for (index in order until this.size) {
            val routes = this[index]

            if (!visited[index] && routes[0] == route) {
                val nextRoute = routes[1]
                val nextRoutes = mutableListOf(nextRoute)

                val copyVisited = visited.copyOf()
                copyVisited[index] = true

                if (copyVisited.all { it }) {
                    return nextRoutes
                }

                val continueRoutes = dfs(index + 1, nextRoute, copyVisited)

                if (copyVisited.count { it } + continueRoutes.size == this.size) {
                    nextRoutes.addAll(continueRoutes)
                    return nextRoutes
                }

                val returnRoutes = dfs(0, nextRoute, copyVisited)

                if (copyVisited.count { it } + continueRoutes.size + returnRoutes.size == this.size) {
                    nextRoutes.addAll(continueRoutes)
                    nextRoutes.addAll(returnRoutes)
                    return nextRoutes
                }
            }
        }

        return mutableListOf()
    }

}
