package io.github.ncc0706.cat

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-10-16 16:27:06 <br/>
 */

fun main() {

    val cat = Cat("Sam")
    val lion = Lion(25)
    val animals = listOf(cat, lion)
    for (animal in animals) {
        animal.eat()
    }

}