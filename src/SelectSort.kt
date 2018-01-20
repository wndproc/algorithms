fun selectSort(array: IntArray): IntArray {
    for (i in 0 until array.lastIndex) {
        var min = i
        for (j in i + 1..array.lastIndex) {
            if (array[min] > array[j]) min = j
        }
        swap(array, i, min)
    }
    return array
}

private fun swap(array: IntArray, i1: Int, i2: Int) {
    if (i1 == i2) return
    var temp = array[i1]
    array[i1] = array[i2]
    array[i2] = temp
}

fun main(args: Array<String>) {
    var array = intArrayOf(6, 5, 4, 3, 2, 1)
    println(selectSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf(1, 9, 2, 54, 1, 54)
    println(selectSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf(1)
    println(selectSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf()
    println(selectSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf(3, 2)
    println(selectSort(array.copyOf()).contentEquals(array.sortedArray()))

    array = intArrayOf(1, 2, 3, 4, 5, 6)
    println(selectSort(array.copyOf()).contentEquals(array.sortedArray()))
}
