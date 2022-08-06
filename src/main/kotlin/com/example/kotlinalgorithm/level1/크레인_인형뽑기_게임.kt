package com.example.kotlinalgorithm.level1

import java.util.Stack

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
class 크레인_인형뽑기_게임 {

    private val stack = Stack<Int>()

    fun solution(board: Array<IntArray>, moves: IntArray) =
        moves.map {
            val getDoll = board.indices.firstOrNull { index ->
                val dollNum = board[index][it - 1]
                dollNum != 0
            }

            getDoll?.run {
                val dollNum = board[this][it - 1]
                board[this][it - 1] = 0

                if (stack.isNotEmpty() && (stack.peek() == dollNum)) {
                    stack.pop()
                    2
                } else {
                    stack.push(dollNum)
                    0
                }
            } ?: 0
        }.toIntArray().sum()

}
