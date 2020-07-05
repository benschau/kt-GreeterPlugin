import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.61"
}

repositories {
    jcenter()
    mavenCentral()
    maven(url="https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly(group="com.destroystokyo.paper", name="paper-api", version="1.16.1-R0.1-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

//val jar by tasks.getting(Jar::class) {
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "plugin.test.GreeterPluginKt"
    }

    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({ 
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) } 
    })
}
