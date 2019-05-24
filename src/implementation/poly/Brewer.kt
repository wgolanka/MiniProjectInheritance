package implementation.poly

import java.time.Year

class Brewer(override val name: String, override val age: Int) : Person(){

    override var points: Long = 0
        set(value) {
            if(value > field){
                field = value
            }
        }

    companion object {
        private const val monthlyActivityPoints = 50
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
