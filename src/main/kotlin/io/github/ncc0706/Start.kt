package io.github.ncc0706

import io.github.ncc0706.chapter01.User

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-09-01 09:35:09 <br/>
 */

fun main(args: Array<String>) {
    val userData: UserData = UserData()
    userData.id = "123";
    userData.username = "123";
    userData.email = "123@gmail.com"

    println(userData.toString())

    val user: User = User("123", userData.username, userData.email)

    println(user)
}