package me.xii69.justonemore.bungee

import net.md_5.bungee.api.event.ProxyPingEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.api.plugin.Plugin
import net.md_5.bungee.event.EventHandler

class JustOneMore() : Plugin(), Listener {
    private lateinit var metrics: Metrics

    override fun onEnable() {
        metrics = Metrics(this, 23661)
        proxy.pluginManager.registerListener(this, this)
    }

    @EventHandler(priority = Byte.MAX_VALUE)
    fun onProxyPing(event: ProxyPingEvent) = event.response.players.apply { max = online + 1 }
}
