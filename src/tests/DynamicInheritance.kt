package tests

import implementation.dynamicinheritance.Brewer
import implementation.dynamicinheritance.Employee
import implementation.dynamicinheritance.PremiumBrewer
import org.junit.Test

class DynamicInheritance {

    @Test
    fun shouldChangeTypeDynamically(){
        //given
        val brewer = Brewer("John", 24)
        brewer.addPointsForMonthlyActivity()
        println(brewer)

        //when
        val employee = Employee(brewer)
        println(employee)
        val premiumBrewer = PremiumBrewer(employee, "30DISCOUNT")
        println(premiumBrewer)


        //then
        assert(employee.name == brewer.name)
        assert(employee.age == brewer.age)
        assert(premiumBrewer.name == employee.name)
    }
}