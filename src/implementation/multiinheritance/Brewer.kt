package implementation.multiinheritance

interface Brewer {

    val points: Int

    fun addPoints(value: Int)
    fun changeAge(value: Int)
    fun checkMinimalAge(age: Int, minimalAge: Int) {
        if (age < minimalAge) {
            throw IllegalStateException("Brewer can't be under 18!")
        }
    }
}