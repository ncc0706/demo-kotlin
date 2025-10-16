package io.github.ncc0706

import java.time.LocalDate

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-09-01 09:35:09 <br/>
 */

typealias Uk = Map<String, String>

fun main(args: Array<String>) {

    // 当前版本
    println("Kotlin version: ${KotlinVersion.CURRENT}")

    /*val msg = "hello world".toByteArray()
    // 内部实现
//    val encode = Base64.Default.encode(msg)
    val encode = Base64.encode(msg)
    println(encode)

    val decode = Base64.decode(encode)
    println(String(decode))*/
    val nums = listOf(12, 10)

    ctx(nums.size)


    val startDate = LocalDate.of(2024, 1, 1)
    val endDate = LocalDate.of(2024, 1, 5)

    // 使用 .. 操作符创建日期区间（依赖 rangeTo 扩展函数）
    val dateRange: ClosedRange<LocalDate> = startDate..endDate

    val uk = hashMapOf<String, String>()
    uk.put("asdf", " sdf");
    uk.put("223", " sdf");
    printUk(uk)
}

fun ctx(size: Int) {
    hello(size)
}

inline fun hello(size: Int) {
    println("Hello world! $size")
}

fun printUk(uk: Uk) {
    println(uk.size)
    println("Uk=${uk.toString()}")
}