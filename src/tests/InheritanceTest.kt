package tests

import implementation.poly.Brewer
import implementation.poly.Person
import implementation.poly.PremiumBrewer
import org.junit.Before
import org.junit.Test
import kotlin.reflect.KClass

class InheritanceTest {

    private var premiumPerson : PremiumBrewer? = null
    private var person : Brewer? = null


    @Before
    fun setUp(){
        premiumPerson = PremiumBrewer("Wiktoria", 22, "SUMMER")
        person = Brewer("Jacob", 27)
    }

    @Test
    fun shouldBeAbstract(){
        //given
        val personClass: KClass<Person> = Person::class

        //then
        assert(personClass.isAbstract)
    }

    @Test
    fun shouldExtendAbstractClass(){
        assert(premiumPerson is Person)
        assert(person is Person)
    }

    @Test
    fun shouldImplementAbstractClassMethod(){
        //when
        val birthYear = premiumPerson?.getBirthYear()

        //then
        assert(birthYear == 1997)
    }

    @Test
    fun shouldImplementPolymorphicMethod(){
        //given
        assert(premiumPerson!!.points == person!!.points)
//        premiumPerson!!.points = 200 // to demonstrate getter and setter

        //when
        premiumPerson!!.addPointsForMonthlyActivity()
        person!!.addPointsForMonthlyActivity()

        //then
        assert(premiumPerson!!.points != person!!.points)
        println("$premiumPerson gets ${premiumPerson!!.points} points")
        println("$person gets ${person!!.points} points")
    }
}