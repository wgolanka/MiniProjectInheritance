package implementation.multiaspectinheritance

class Tea(override val name: String, override val isCaffeineBrew: Boolean, teaType: Enum<TeaType>) : Brew() {

    private var teaType = teaType

    fun changeTeaType(type: TeaType){
        teaType = type
    }

    override fun toString(): String {
        return "Tea(name='$name', isCaffeineBrew=$isCaffeineBrew, teaType=$teaType)"
    }
}

enum class TeaType {
    GREEN, BLACK, YELLOW, ROOIBOS
}
