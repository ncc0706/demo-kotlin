import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import kotlin.collections.forEach
import java.io.DataInputStream
import java.io.FileInputStream

plugins {
    kotlin("jvm") version "2.2.20"
    id("com.vanniktech.maven.publish") version "0.34.0"
}

group = "io.github.ncc0706"
version = "0.0.1-SNAPSHOT"


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

kotlin {
    jvmToolchain(11)
    compilerOptions{
        jvmTarget = JvmTarget.JVM_11
        // 但不建议这样做，会破坏 Kotlin 的空安全保证。
        freeCompilerArgs.add("-Xno-param-assertions")
    }
}


dependencies {
    // 1.8.0开始 kotlin-stdlib-jdk8 里面的实现已经迁移到 kotlin-stdlib 中，所以不需要再依赖这个
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.20")
    testImplementation(kotlin("test"))
}


tasks.test {
    useJUnitPlatform()
}

mavenPublishing {
    publishToMavenCentral(true)
    configure(JavaLibrary(JavadocJar.Empty(), false))
    // Enable GPG signing for all publications
    signAllPublications()

    pom {
        name = "demo-kotlin"
        description = "demo kotlin"
        url = "https://github.com/ncc0706/demo-kotlin"
        licenses {
            license {
                name = "The Apache Software License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "ncc0706"
                name = "ncc0706"
                email = "ncc0706@gmail.com"
            }
        }
        scm {
            connection = "scm:git:https://github.com/ncc0706/demo-kotlin.git"
            developerConnection = "scm:git:https://github.com/ncc0706/demo-kotlin.git"
            url = "https://github.com/ncc0706/demo-kotlin"
        }
        properties.set(mapOf(
            "java.version" to "11",
            "kotlin.compiler.jvmTarget" to "11"
        ))
    }
}

// 查看编译后支持jvm版本
tasks.register("checkBytecodeVersion") {
    doLast {
        fileTree("build/classes").matching { include("**/*.class") }.forEach { classFile ->
            try {
                DataInputStream(FileInputStream(classFile)).use { input ->
                    // 跳过魔数 (0xCAFEBABE)
                    val magic = input.readInt()
                    if (magic != 0xCAFEBABE.toInt()) {
                        logger.warn("${classFile.name} is not a valid class file")
                        return@forEach
                    }

                    // 读取次要版本和主要版本
                    val minorVersion = input.readUnsignedShort()
                    val majorVersion = input.readUnsignedShort()

                    println("${classFile.absolutePath}: minorVersion($minorVersion) major version = $majorVersion")
                }
            } catch (e: Exception) {
                logger.error("Error reading ${classFile.absolutePath}: ${e.message}")
            }
        }
    }
}