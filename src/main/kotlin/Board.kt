class Board(val data: Array<BooleanArray>, val path: MutableList<Pair<Int, Int>> = mutableListOf()){
    fun toggle(x: Int, y: Int) {
        path.add(Pair(x, y))
        for(i in -1..1 step 2) {
            if(x+i in 0..2 ) {
                this.data[y][x+i] = !this.data[y][x+i]
            }
            if(y+i in 0..2 ) {
                this.data[y+i][x] = !this.data[y+i][x]
            }
        }
        this.data[y][x] = !this.data[y][x]
    }

    override fun equals(other: Any?): Boolean {
        other as Board
        for (y in 0..2) {
            for (x in 0..2) {
                if(this.data[y][x] != other.data[y][x]) {
                    return false
                }
            }
        }
        return true
    }

    fun toInt(): Int {
        return this.data.joinToString("") { it.map { i -> if (i) 1 else 0 }.joinToString("") }.toInt(2)
    }

    fun copy(): Board {
        return Board(arrayOf(
            this.data[0].copyOf(),
            this.data[1].copyOf(),
            this.data[2].copyOf()
        ), this.path.map{Pair(it.first, it.second)}.toMutableList())
    }
}