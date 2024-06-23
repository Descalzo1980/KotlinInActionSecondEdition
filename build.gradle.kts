plugins {
    kotlin("jvm") version "1.9.0"
}

group = "dev.stas"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test-jvm:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.24")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}