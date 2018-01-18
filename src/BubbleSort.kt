fun bubbleSort(array: IntArray) : IntArray {
    for (i in array.lastIndex downTo 1) {
        for (j in 0 until i) {
            if (array[j] > array[j+1]) swap(array, j, j+1)
        }
    }
    return array
}

fun swap(array: IntArray, i1: Int, i2: Int){
    var temp = array[i1]
    array[i1] = array[i2]
    array[i2] = temp
}

fun main(args: Array<String>) {
    var array = intArrayOf(6, 5, 4, 3, 2, 1)
    println (bubbleSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf(1, 9, 2, 54, 1, 54)
    println (bubbleSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf(1)
    println (bubbleSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf()
    println (bubbleSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf(3, 2)
    println (bubbleSort(array.copyOf()).contentEquals(array.sortedArray()))
}