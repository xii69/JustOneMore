plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.xii69"
version = "2.0.0"
val slug = "justonemore"

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "jitpack.io"
        url = uri("https://jitpack.io")
    }
}

dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    compileOnly("com.github.LeonMangler:PremiumVanishAPI:2.9.0-4")
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