import java.util.PriorityQueue

val input = Board(
    arrayOf(
        booleanArrayOf(false, true, false),
        booleanArrayOf(true, false, false),
        booleanArrayOf(false, false, false)
    )
)

val solution = Board(
    arrayOf(
        booleanArrayOf(false, false, false),
        booleanArrayOf(false, false, false),
        booleanArrayOf(false, false, false)
    )
)
val queue = PriorityQueue(BoardComparator)
val map = mutableMapOf<Int, Board>()

fun main() {
    queue.add(input)
    map[input.toInt()] = input
    while(!map.containsKey(solution.toInt())) {
        processBoard(queue.remove())
    }
    val final = map[solution.toInt()]
    if (final != null) {
        println(final.path.count())
        println(final.path.joinToString ( "\n" ))
    }
}

fun processBoard(board: Board) {
    for(y in 0..2) {
        for(x in 0..2) {
            val temp = board.copy()
            temp.toggle(x, y)
            if(!map.containsKey(temp.toInt())) {
                queue.add(temp)
                map[temp.toInt()] = temp
            }
        }
    }
}
