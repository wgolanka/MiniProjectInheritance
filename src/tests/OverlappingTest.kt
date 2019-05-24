package tests

import implementation.overlapping.Brew
import implementation.overlapping.BrewType
import org.junit.Test
import java.util.*
import kotlin.test.assertFails

class OverlappingTest {

    private val caffeineAndHerbalBrewTypes = listOf(BrewType.BREW, BrewType.CAFFEINE, BrewType.HERBAL)
    private val nonCaffeineAndHerbalBrewTypes = listOf(BrewType.BREW, BrewType.NO_CAFFEINE, BrewType.HERBAL)
    private val caffeineBrewTypes = listOf(BrewType.BREW, BrewType.CAFFEINE)
    private val MINT = "Mint"
    private val THYME = "Thyme"

    @Test
    fun shouldBeCaffeineAndHerbal(){
        //given
        val brew = Brew("Black Tea", 10, mutableListOf(MINT, THYME))
        brew.setCaffeineMg(15)

        //
        //when
        val caffeineMg = brew.getCaffeineMg()

        //then
        assert(caffeineMg > 0)
        assert(brew.getHerbs().isNotEmpty())
        assert(brew.getTypes().containsAll(caffeineAndHerbalBrewTypes))
        println(brew)
        println(brew.getCaffeineMg())
    }

    @Test
    fun shouldBeNonCaffeineAndHerbal(){
        //given
        val brew = Brew("Rooibos", 0, mutableListOf(MINT))

        //when
        assertFails { brew.getCaffeineMg() }
        assertFails { brew.setCaffeineMg(10) }
        assert(brew.getHerbs().isNotEmpty())
        assert(brew.getTypes().containsAll(nonCaffeineAndHerbalBrewTypes))
        println(brew)
    }

    @Test
    fun shouldChangeToHerbal(){
        //given
        val brew = Brew("Black Tea", 10, mutableListOf())
        println(brew)
        assert(caffeineBrewTypes.containsAll(brew.getTypes()))

        //when
        brew.addHerb(MINT)

        //then
        assert(brew.getTypes().containsAll(caffeineAndHerbalBrewTypes))
        assert(brew.getHerbs().contains(MINT))
        println(brew)
    }

    @Test
    fun shouldRemoveTea(){
        //given
        val brew = Brew("Black Tea", 10, mutableListOf(MINT, THYME))
        println(brew)
        assert(caffeineAndHerbalBrewTypes.containsAll(brew.getTypes()))

        //when
        brew.removeHerb(MINT)

        //then
        assert(brew.getTypes().containsAll(caffeineAndHerbalBrewTypes))
        assert(!brew.getHerbs().contains(MINT))
        println(brew)
    }

    @Test
    fun shouldRemoveTeaAndChangeType(){
        //given
        val brew = Brew("Black Tea", 10, mutableListOf(THYME))
        brew.setHerbs(mutableListOf(MINT))
        println(brew)
        assert(caffeineAndHerbalBrewTypes.containsAll(brew.getTypes()))

        //when
        brew.removeHerb(MINT)

        //then
        assert(brew.getTypes().containsAll(caffeineBrewTypes))
        assertFails { brew.getHerbs() }
        assertFails { brew.setHerbs(mutableListOf(MINT)) }
        println(brew)
    }

    @Test
    fun shouldSetTypes(){
        //given
        val brew = Brew("Black Tea", 10, mutableListOf())
        println(brew)
        assert(caffeineAndHerbalBrewTypes.containsAll(brew.getTypes()))

        //when
        brew.setTypes(EnumSet.of(BrewType.BREW, BrewType.CAFFEINE, BrewType.HERBAL))

        //then
        assert(brew.getTypes().containsAll(caffeineBrewTypes))
        brew.setHerbs(mutableListOf(MINT))
        assert(brew.getHerbs().isNotEmpty())
        println(brew)
    }
}