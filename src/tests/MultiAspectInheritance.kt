package tests

import implementation.multiaspectinheritance.Coffee
import implementation.multiaspectinheritance.CoffeeType
import implementation.multiaspectinheritance.Tea
import implementation.multiaspectinheritance.TeaType
import org.junit.Test

class MultiAspectInheritance {

    @Test
    fun shouldShowAspectInheritance(){ //dzielone ze względu na typ ( herbata, kawa ) i ze względu na zawartośc kofeiny (flaga)
        //given
        val coffeeBrew = Coffee("Strong black", true, CoffeeType.ARABICA)
        val teaBrew = Tea("Shrub", false, TeaType.ROOIBOS)
        println("\n$coffeeBrew\n$teaBrew\n")

        //when //then
        assert(coffeeBrew.hasCaffeine())
        assert(!teaBrew.hasCaffeine())

        if (coffeeBrew.hasCaffeine()){
            println("$coffeeBrew is caffeine type")
        }
        if (!teaBrew.hasCaffeine()){
            println("$teaBrew is not caffeine type")
        }

        teaBrew.changeTeaType(TeaType.BLACK)
        coffeeBrew.changeCoffeeType(CoffeeType.ROBUSTA)
        println("\n$coffeeBrew\n$teaBrew\n")

    }
}