plugins {
    kotlin("jvm") version "2.0.21"
    id("com.gradleup.shadow") version "8.3.3"
}

group = "me.xii69"
version = "2.0.1"
val slug = "justonemore"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}

tasks {
    processResources {
        filesMatching("**plugin.json") {
            expand(
                "version" to version,
                "slug" to slug,
                "name" to rootProject.name,
                "description" to rootProject.description
            )
        }
    }
}
