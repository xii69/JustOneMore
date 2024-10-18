package me.xii69.justonemore.bukkit

import me.xii69.justonemore.shared.Metrics.Factory
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent
import org.bukkit.plugin.java.JavaPlugin

class JustOneMore(
    private val metricsFactory: Factory
) : JavaPlugin(), Listener {
    override fun onEnable() {
        metricsFactory.make(this, 22308)
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun onServerListPing(event: ServerListPingEvent) = event.apply { maxPlayers = numPlayers + 1 }
}
