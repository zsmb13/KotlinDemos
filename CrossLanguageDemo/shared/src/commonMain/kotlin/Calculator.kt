import kotlin.math.sqrt

class Calculator {
    fun circleArea(radius: Double): Double {
        val range = 1..100_000
        val sum = range.sumOf { 1.0 / it / it }
        val pi = sqrt(sum * 6.0)
        println("Pi is $pi")
        return radius * radius * pi
    }
}