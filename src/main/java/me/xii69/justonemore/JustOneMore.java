package me.xii69.justonemore;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.server.ServerPing;

@Plugin(
        id = "justonemore",
        name = "JustOneMore",
        version = "1.1.0",
        description = "JustOneMore plugin for Velocity",
        authors = {"xii69"}
)

public class JustOneMore {

    @Subscribe
    public void onProxyPing(ProxyPingEvent event) {
        final ServerPing serverPing = event.getPing();
        if (serverPing.getPlayers().isPresent()) {
            final ServerPing.Builder builder = serverPing.asBuilder();
            final int onlinePlayers = builder.getOnlinePlayers();
            event.setPing(builder.maximumPlayers(onlinePlayers + 1).build());
        }
    }
}
