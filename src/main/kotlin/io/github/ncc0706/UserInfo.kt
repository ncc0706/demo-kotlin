package io.github.ncc0706

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @version 1.0
 * @since 2025-10-16 16:15:36 <br/>
 */
class UserInfo {

    // 必填给默认值
    // 显示设置为null
//    var name: String? = null

    // 适用于非空属性
    lateinit var name: String

}

fun main() {
    val userInfo = UserInfo()

    println(userInfo.name)
}