package implementation.multiinheritance

import java.lang.IllegalStateException

class PremiumBrewer(name: String, override var age: Int, override val points: Int) : Person(), Brewer {

    override val name = name
        get() {
            return "PremiumBrewer: $field"
        }

    init {
        checkMinimalAge(age, 18)
    }

    @Override
    override fun addPoints(value: Int) {
        if (value < 0){
            throw IllegalStateException("Can't minus the points!")
        }
        points.plus(value)
    }

    override fun changeAge(value: Int) {
        age = value
    }

    override fun toString(): String {
        return "PremiumBrewer(age=$age, points=$points)"
    }
}