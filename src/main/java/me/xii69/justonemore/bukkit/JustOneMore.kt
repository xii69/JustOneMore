package me.xii69.justonemore.bukkit

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent
import org.bukkit.plugin.java.JavaPlugin

class JustOneMore() : JavaPlugin(), Listener {
    private lateinit var metrics: Metrics

    override fun onEnable() {
        metrics = Metrics(this, 23662)
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun onServerListPing(event: ServerListPingEvent) = event.apply { maxPlayers = numPlayers + 1 }
}
