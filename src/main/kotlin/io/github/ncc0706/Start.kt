package io.github.ncc0706

import kotlin.io.encoding.Base64

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-09-01 09:35:09 <br/>
 */

fun main(args: Array<String>) {


    val msg = "hello world".toByteArray()
    val encode = Base64.Default.encode(msg)
    val encode1 = Base64.encode(msg)
    println(encode)
    println(encode1)

    val decode = Base64.decode(encode)
    println(String(decode))

}