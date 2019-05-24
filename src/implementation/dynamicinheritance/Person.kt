package implementation.dynamicinheritance

abstract class Person {
    abstract val name : String
    abstract val age : Int
    abstract var points : Long

    abstract fun getBirthYear(): Int
    abstract fun addPointsForMonthlyActivity()
}
