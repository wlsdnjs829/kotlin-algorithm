package com.example.kotlinalgorithm.level2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=kotlin
 */
class 두_큐_합_같게_만들기 {

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val firstQueue = ArrayDeque(queue1.map { it.toLong() }.toList())
        val secondQueue = ArrayDeque(queue2.map { it.toLong() }.toList())

        return getMinCount(firstQueue, secondQueue, firstQueue.sum(), secondQueue.sum(), 0, queue1.size * 3)
    }

    private tailrec fun getMinCount(
        firstQueue: ArrayDeque<Long>,
        secondQueue: ArrayDeque<Long>,
        firstSum: Long,
        secondSum: Long,
        count: Int,
        chance: Int
    ): Int {
        when {
            firstSum == secondSum -> return count
            count == chance -> return -1
            firstSum > secondSum -> {
                val data = firstQueue.removeFirst()
                secondQueue.add(data)

                return getMinCount(
                    firstQueue, secondQueue,
                    firstSum - data, secondSum + data, count + 1, chance
                )
            }
            else -> {
                val data = secondQueue.removeFirst()
                firstQueue.add(data)

                return getMinCount(
                    firstQueue, secondQueue,
                    firstSum + data, secondSum - data, count + 1, chance
                )
            }
        }
    }

}
