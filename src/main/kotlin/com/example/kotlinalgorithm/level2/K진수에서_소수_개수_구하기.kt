package com.example.kotlinalgorithm.level2

import kotlin.math.sqrt

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
class K진수에서_소수_개수_구하기 {

    fun solution(n: Int, k: Int) =
            n.run { convertBase(n, k, StringBuilder()) }
                    .split("0")
                    .count { it.isNotEmpty() && it.toDouble().isPrime() }

    private tailrec fun convertBase(n: Int, k: Int, sb: StringBuilder): String {
        return if (n > 0) {
            convertBase(n / k, k, sb.append(n.rem(k)))
        } else {
            sb.reverse().toString()
        }
    }

    private fun Double.isPrime(): Boolean {
        return this > 1 && (2..sqrt(this).toInt()).none { this.rem(it) == 0.0 }
    }

    /*
    fun solution(n: Int, k: Int) =
            n.run { toString(k) }
                    .split("0")
                    .count { it.isNotEmpty() && it.toBigInteger().isProbablePrime(1) }
     */

}
