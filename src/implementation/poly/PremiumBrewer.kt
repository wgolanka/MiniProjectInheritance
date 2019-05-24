package implementation.poly

import java.time.Year

class PremiumBrewer(override val name: String, override val age: Int, private val discountCode: String) : Person() {

    override var points: Long = 0
        set(value) {
            if(value > field){
                field = value
            }
        }

    companion object {
        private const val monthlyActivityPoints = 20
    }

    @Override
    override fun getBirthYear() : Int {
        return Year.now().value - age
    }

    @Override
    override fun addPointsForMonthlyActivity() {
       points += monthlyActivityPoints
    }

    @Override
    override fun toString(): String {
        return "PremiumBrewer(name='$name', age=$age)"
    }

//    fun getPoints() : Long { // getter and setter is already generated
//        return points
//    }

    fun getDiscountCode(): String {
        return discountCode
    }
}
