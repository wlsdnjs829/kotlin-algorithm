package com.example.kotlinalgorithm.method

class 비트_연산자 {

    private fun isUnique() {
        val size = 10 // 10 -> 배열 사이즈

        (1 until (1 shl size)) // 0001에서 왼쪽으로 사이즈만큼 시프트 (0001 -> 1000,
            .forEach { index ->
                (0 until size) // 0부터 배열 칸 수만큼 반복
                    .filter { index and (1 shl it) != 0 } // 최소 한 자리 포함하는지 필터링
                    .toList()
            }

    }

}