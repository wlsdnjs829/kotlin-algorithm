package com.example.kotlinalgorithm.level1

import kotlin.math.abs

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
class 키패드_누르기 {

    private var leftHand = 10
    private var rightHand = 12

    private val onlyLeft = intArrayOf(1, 4, 7, 10)
    private val onlyRight = intArrayOf(3, 6, 9, 12)

    fun solution(numbers: IntArray, hand: String) =
        numbers.joinToString("") {
            when (it) {
                in onlyLeft -> goLeft(it)
                in onlyRight -> goRight(it)
                else -> goNearHand(it, hand)
            }
        }

    private fun goNearHand(position: Int, hand: String): String {
        val currentPosition = convertZero(position)
        val leftDistance = getDistance(currentPosition, leftHand)
        val rightDistance = getDistance(currentPosition, rightHand)

        return when (leftDistance.compareTo(rightDistance)) {
            -1 -> goLeft(currentPosition)
            1 -> goRight(currentPosition)
            else -> if (hand == "right") goRight(currentPosition) else goLeft(currentPosition)
        }
    }

    private fun convertZero(position: Int) = if (position == 0) 11 else position

    private fun getDistance(position: Int, handPosition: Int) =
        abs(((position - handPosition) % 3) + ((position - handPosition) / 3))

    private fun goRight(position: Int): String {
        rightHand = position
        return "R"
    }

    private fun goLeft(position: Int): String {
        leftHand = position
        return "L"
    }

}
