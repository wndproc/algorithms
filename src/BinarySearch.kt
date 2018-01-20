fun binarySearch(array: IntArray, value: Int): Int? {
    var left = 0
    var right = array.lastIndex
    while (left <= right) {
        var middle = left + (right - left) / 2
        when {
            array[middle] == value -> return middle
            array[middle] < value -> left = middle + 1
            array[middle] > value -> right = middle - 1
        }
    }
    return null
}

fun binarySearchRecursive(array: IntArray, value: Int): Int? = binarySearchRecursive(array, value, 0, array.lastIndex)

fun binarySearchRecursive(array: IntArray, value: Int, left: Int, right: Int): Int? {
    if (left > right) return null
    var middle = left + (right - left) / 2
    when {
        array[middle] == value -> return middle
        array[middle] < value -> return binarySearchRecursive(array, value, middle + 1, right)
        array[middle] > value -> return binarySearchRecursive(array, value, left, middle - 1)
    }
    return null
}

fun main(args: Array<String>) {
    println("Binary search")
    assertBinarySearch(::binarySearch)
    testNumber = 1
    println("\nRecursive binary search")
    assertBinarySearch(::binarySearchRecursive)
}

fun assertBinarySearch(binarySearch: (array: IntArray, value: Int) -> Int?) {
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 3) == 2 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 1) == 0 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 5) == 4 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 6) == 5 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5, 6), 7) == null }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5), 3) == 2 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5), 1) == 0 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5), 5) == 4 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5), 2) == 1 }
    assert { binarySearch(intArrayOf(1, 2, 3, 4, 5), 7) == null }
    assert { binarySearch(intArrayOf(1), 1) == 0 }
    assert { binarySearch(intArrayOf(1), 7) == null }
    assert { binarySearch(intArrayOf(), 7) == null }
}

var testNumber = 1

fun assert(function: () -> Boolean) {
    if (function()) {
        println("$testNumber OK")
    } else {
        println("$testNumber Fail")
    }
    testNumber++
}
