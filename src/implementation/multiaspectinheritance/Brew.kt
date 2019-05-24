package implementation.multiaspectinheritance

abstract class Brew {
    abstract val name : String
    abstract val isCaffeineBrew : Boolean

    fun hasCaffeine() : Boolean {
        return isCaffeineBrew
    }
}