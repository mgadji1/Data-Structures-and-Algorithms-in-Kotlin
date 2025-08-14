fun main() {
    val arrayList = ArrayList<Int>()

    arrayList.add(10)
    arrayList.add(20)
    arrayList.add(30)
    arrayList.add(40)

    println(arrayList)

    arrayList.add(2, 15)
    arrayList.add(1, 5)

    println(arrayList)

    println(arrayList.get(1))
    println(arrayList.get(3))

    println(arrayList.set(1, 17))
    println(arrayList.set(3, 38))

    println(arrayList)

    println(arrayList.remove(2))

    println(arrayList)

    println(arrayList.contains(38))
    println(arrayList.size())

    println(arrayList.isEmpty())

    arrayList.clear()

    println(arrayList.isEmpty())

    println(arrayList)
}