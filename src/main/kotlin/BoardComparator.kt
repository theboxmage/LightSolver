class BoardComparator {

    companion object : Comparator<Board> {

        override fun compare(a: Board, b: Board): Int = when {
            a.path.size != b.path.size -> a.path.size - b.path.size
            else -> 0
        }
    }
}