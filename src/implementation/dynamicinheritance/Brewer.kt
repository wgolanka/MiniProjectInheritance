package implementation.dynamicinheritance

import java.time.Year

class Brewer(override val name: String, override val age: Int) : Person(){

    companion object {
        private const val monthlyActivityPoints = 50
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
    override fun getBirthYear(): Int {
        return Year.now().value - age
    }

    @Override
    override fun addPointsForMonthlyActivity() {
        points += monthlyActivityPoints
    }

    override fun toString(): String {
        return "Brewer(name='$name', age=$age)"
    }
}
