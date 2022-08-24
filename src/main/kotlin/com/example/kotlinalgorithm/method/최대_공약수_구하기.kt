package com.example.kotlinalgorithm.method

class 최대_공약수_구하기 {

    private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

}