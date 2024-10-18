package me.xii69.justonemore.bungee

import me.xii69.justonemore.shared.Metrics.Factory
import net.md_5.bungee.api.event.ProxyPingEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.api.plugin.Plugin
import net.md_5.bungee.event.EventHandler

class JustOneMore(
    private val metricsFactory: Factory
) : Plugin(), Listener {
    override fun onEnable() {
        metricsFactory.make(this, 22308)
        proxy.pluginManager.registerListener(this, this)
    }

    @EventHandler(priority = Byte.MAX_VALUE)
    fun onProxyPing(event: ProxyPingEvent) = event.response.players.apply { max = online + 1 }
}
