package implementation.multiinheritance

import java.lang.IllegalStateException

class CasualBrewer(name: String, override var age: Int, override var points: Int) : Person(), Brewer {

    init {
        checkMinimalAge(age, 12)
    }

    override val name = name
        get() {
            return "CasualBrewer: $field"
        }

    override fun addPoints(value: Int) {
        if (value < 0){
            throw IllegalStateException("Can't minus the points!")
        }
        points += value * 2
    }

    override fun changeAge(value: Int) {
       age = value
    }

    override fun toString(): String {
        return "CasualBrewer(age=$age, points=$points)"
    }

}