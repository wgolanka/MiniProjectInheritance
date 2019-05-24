package implementation.dynamicinheritance

import java.time.Year

class Employee(override val name: String, override val age: Int) : Person() {

    companion object {
        private const val monthlyActivityPoints = 5
    }

    override var points: Long = 0
        set(value) {
            if(value > field){
                field = value
            }
        }

    constructor(person: Person) : this(person.name, person.age) {
        points = person.points
    }

    @Override
    override fun getBirthYear() : Int {
        return Year.now().value - age
    }

    override fun addPointsForMonthlyActivity() {
        points.plus(monthlyActivityPoints)
    }

    override fun toString(): String {
        return "Employee(name='$name', age=$age, points=$points)"
    }
}