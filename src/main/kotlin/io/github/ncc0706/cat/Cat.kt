package io.github.ncc0706.cat

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-10-16 16:24:40 <br/>
 */
class Cat(val name: String) : CatsFamily() {
    override fun eat() {
        println("$name is eating")
    }
}