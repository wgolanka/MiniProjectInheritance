package implementation.multiaspectinheritance

class Coffee(override val name: String, override val isCaffeineBrew: Boolean, private var coffeeType: Enum<CoffeeType>) : Brew() {

    fun changeCoffeeType(type: Enum<CoffeeType>){
        coffeeType = type
    }

    override fun toString(): String {
        return "Coffee(name='$name', isCaffeineBrew=$isCaffeineBrew, coffeeType=$coffeeType)"
    }
}

enum class CoffeeType {
    ARABICA, ROBUSTA
}
