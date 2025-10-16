package io.github.ncc0706

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-10-16 15:40:15 <br/>
 */
enum class ProductType(title: String, value: Int) {

    MUSIC("music", 1),
    FOOD("Food", 0),
    APPLIANCE("Appliance", 2),
    SHOE("shoe", 3)

}

fun main() {

    for ((index, product) in ProductType.entries.withIndex()) {
        println("$index: $product")
    }

}