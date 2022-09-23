package com.example.kotlinalgorithm.깊이_너비_우선_탐색

fun main() {
    val solution = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 1))

    println(
        퍼즐_조각_채우기_L3().solution(
            solution,
            arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 0), intArrayOf(0, 0, 0))
        )
    )
}

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84021
 */
class 퍼즐_조각_채우기_L3 {

    private var width = 0
    private var height = 0

    private var minWidth = 0
    private var minHeight = 0

    private var area = 0

    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        val size = game_board.size
        val visited = Array(size) { BooleanArray(size) { false } }

        for (columns in 0 until size) {
            for (row in 0 until size) {
                if (visited[row][columns]) {
                    continue
                }

                visited[row][columns] = true

                if (game_board[row][columns] == 0) {
                    width = 1
                    height = 1
                    minWidth = Int.MAX_VALUE
                    minHeight = columns
                    area++

                    val tempBoard = Array(size) { IntArray(size) { 0 } }
                    tempBoard[row][columns] = 1

                    game_board.findEmpty(visited, row, columns, tempBoard)

                    val tempVisited = Array(height) { IntArray(width) { 0 } }

                    for (tempRow in minHeight until minHeight + height) {
                        for (tempColumns in minWidth until minWidth + width) {
                            tempVisited[tempRow - minHeight][tempColumns - minWidth] = tempBoard[tempRow][tempColumns]
                        }
                    }

                    // 공간까지 압축 시킴
                    println(tempVisited)
                    
                    // todo 압축 리스트를 넣고 90도씩 돌리며 회전 시킨다. 총 4번
                }
            }
        }

        // table에서도 빈 공간을 찾아 공간 압축 시킨다
        
        // 압축 시킨 두 리스트를 비교하며 일치하는 넓이만큼 뺀다
        
        // 넓이 반환
        
        var answer: Int = -1
        return answer
    }

    private fun Array<IntArray>.findEmpty(
        visited: Array<BooleanArray>,
        row: Int,
        columns: Int,
        tempBoard: Array<IntArray>
    ) {
        val leftRow = row - 1
        val rightRow = row + 1
        val underColumn = columns + 1
        val overColumn = columns - 1

        this.check(leftRow >= 0, leftRow, visited, columns, tempBoard, true)
        this.check(rightRow < this.size, rightRow, visited, columns, tempBoard, true)
        this.check(underColumn < this.size, row, visited, underColumn, tempBoard, false)
        this.check(overColumn >= 0, row, visited, overColumn, tempBoard, false)
    }

    private fun Array<IntArray>.check(
        check: Boolean,
        row: Int,
        visited: Array<BooleanArray>,
        columns: Int,
        tempBoard: Array<IntArray>,
        isHeight: Boolean
    ) {
        if (check && !visited[row][columns] && this[row][columns] == 0) {
            visited[row][columns] = true
            tempBoard[row][columns] = 1
            area++
            if (isHeight) {
                if (minHeight > columns) minHeight = columns
                height++
            } else {
                if (minWidth > row) minWidth = row
                width++
            }
            this.findEmpty(visited, row, columns, tempBoard)
        }
    }

}
