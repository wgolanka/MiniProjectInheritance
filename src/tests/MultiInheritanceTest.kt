package tests

import implementation.multiinheritance.CasualBrewer
import implementation.multiinheritance.PremiumBrewer
import org.junit.Test
import kotlin.test.assertFails

class MultiInheritanceTest {

    @Test
    fun shouldShowSameMethodInvocation(){
        //given
        val casualBrewer = CasualBrewer("Jack", 19, 100)
        val premiumBrewer = PremiumBrewer("Olo", 21, 2000)
        println("\n$casualBrewer\n$premiumBrewer")

        //when
        casualBrewer.addPoints(50)
        premiumBrewer.addPoints(50)

        //when
        assert(casualBrewer.points == 200)
        assert(premiumBrewer.points == 2050)
        assertFails { CasualBrewer("Too young", 10, 100) }
        println("\n$casualBrewer\n$premiumBrewer")
    }
}