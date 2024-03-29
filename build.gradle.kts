plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.9.1")
    implementation("com.codeborne:selenide:7.0.2")
}

tasks.test {
    useJUnitPlatform()
}