package me.xii69.justonemore.velocity

import com.google.inject.Inject
import com.velocitypowered.api.event.PostOrder
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyPingEvent
import me.xii69.justonemore.shared.Metrics.Factory

class JustOneMore @Inject constructor(
    private val metricsFactory: Factory
) {
    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) = metricsFactory.make(this, 22308)

    @Subscribe(order = PostOrder.LAST)
    fun onProxyPing(event: ProxyPingEvent) {
        if (event.ping.players.isPresent) event.ping = event.ping.asBuilder().maximumPlayers(event.ping.asBuilder().onlinePlayers + 1).build()
    }
}
