plugins {
    id("java")
    id("com.diffplug.spotless") version "8.10.1"
    checkstyle
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        // Enforces the standard Google Java Style Guide
        googleJavaFormat()

        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
    }
}

checkstyle {
    toolVersion = "14.1.0"
    configFile = rootProject.file("config/checkstyle/google_checks.xml")
}