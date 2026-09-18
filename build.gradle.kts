plugins {
    kotlin("jvm") version "2.4.20"
    id("com.gradleup.shadow") version "9.6.1"
}

group = "me.xii69"
version = "3.0.1"
description = "JustOneMore"
val author = "xii69"
val projectId = "justonemore"
val projectName = "JustOneMore"
val bukkitMain = "me.xii69.justonemore.bukkit.JustOneMore"
val bungeeMain = "me.xii69.justonemore.bungee.JustOneMore"
val velocityMain = "me.xii69.justonemore.velocity.JustOneMore"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("net.md-5:bungeecord-api:1.21-R0.5-SNAPSHOT")
    compileOnly("org.spigotmc:spigot-api:26.3-R0.1-SNAPSHOT")
    compileOnly("com.velocitypowered:velocity-api:4.1.2-SNAPSHOT")
}

kotlin {
    jvmToolchain(25)
}

tasks {
    processResources {
        filesMatching(listOf("plugin.yml", "bungee.yml", "velocity-plugin.json")) {
            expand(
                "name" to projectName,
                "version" to version,
                "author" to author,
                "projectId" to projectId,
                "bukkitMain" to bukkitMain,
                "bungeeMain" to bungeeMain,
                "velocityMain" to velocityMain,
                "description" to projectName,
            )
        }
    }
}
