package io.github.ncc0706

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-10-16 16:59:30 <br/>
 */

class User(val name: String, age: Int) : Cleaner, Supplier {
    var salary: Int = 0
//        set(value) {
//            field = value
//        }
//        get() {
//            return field
//        }

    override fun clean() {
        TODO("Not yet implemented")
    }

    override fun buyThings() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "super.toString()"
    }
}

fun main() {

    val user = User("tom", 22)
    println(user.salary)
    print(user.toString())


}