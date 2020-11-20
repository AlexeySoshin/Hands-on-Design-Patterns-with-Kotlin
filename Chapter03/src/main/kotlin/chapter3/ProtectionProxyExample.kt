package chapter3

fun main() {
    val alex = Employee(10_000)
}


interface CanAskForSalaryIncrease : HasSalary {
    fun askForIncrease(percent: Int)
}

interface HasSalary {
    val salary: Int
}

data class Employee(override var salary: Int): CanAskForSalaryIncrease by ProtectionProxy(salary)

class ProtectionProxy(override val salary: Int) : CanAskForSalaryIncrease {
    override fun askForIncrease(percent: Int) {
        if (percent <= 0) {
            throw RuntimeException("Zero or negative percent")
        }
        else if (percent > 15) {
            throw RuntimeException("Cannot raise salary more than 15%")
        }
        salary
    }
}
