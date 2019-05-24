package implementation.overlapping

import java.lang.IllegalStateException
import java.util.*

class Brew(private var name: String, private var caffeineMg: Int, private var herbs: MutableList<String>) {

    private val MAX_DAILY_INTAKE = 400

    private var brewTypes: EnumSet<BrewType> = EnumSet.of(BrewType.BREW)

    init {
        when (caffeineMg) {
            0 -> brewTypes.add(BrewType.NO_CAFFEINE)
            in 1..MAX_DAILY_INTAKE -> brewTypes.add(BrewType.CAFFEINE)
            else -> throw IllegalStateException("Brew can't have $caffeineMg of caffeine!")
        }

        if (herbs.isNotEmpty()) {
            brewTypes.add(BrewType.HERBAL)
        }
    }

    fun getCaffeineMg(): Int {
        throwExceptionWhenHasNo(BrewType.CAFFEINE)
        return caffeineMg
    }

    fun setCaffeineMg(milligrams: Int) {
        throwExceptionWhenHasNo(BrewType.CAFFEINE)
        if (milligrams in 1..MAX_DAILY_INTAKE) {
            caffeineMg = milligrams
        } else {
            throw IllegalStateException("Must have more then 0 mg and less than $MAX_DAILY_INTAKE mg")
        }
    }

    fun getHerbs(): List<String> {
        throwExceptionWhenHasNo(BrewType.HERBAL)
        return herbs
    }

    fun setHerbs(givenHerbs: MutableList<String>) {
        throwExceptionWhenHasNo(BrewType.HERBAL)
        if (givenHerbs.size > 0) {
            herbs = givenHerbs
        } else {
            throw IllegalStateException("Must have at least one herb!")
        }
    }

    private fun throwExceptionWhenHasNo(type: BrewType) {
        if (!brewTypes.contains(type)) {
            throw IllegalStateException("$name is not ${type.name} brew!")
        }
    }

    fun setTypes(types: EnumSet<BrewType>) {
        brewTypes = types
    }

    fun getTypes(): EnumSet<BrewType> {
        return brewTypes
    }

    fun addHerb(herb: String) {
        brewTypes.add(BrewType.HERBAL)
        herbs.add(herb)
    }

    fun removeHerb(herb: String) {
        herbs.remove(herb)
        if (herbs.isEmpty()) {
            brewTypes.remove(BrewType.HERBAL)
        }
    }

    override fun toString(): String {
        return "Brew(name='$name', brewTypes=$brewTypes)"
    }
}