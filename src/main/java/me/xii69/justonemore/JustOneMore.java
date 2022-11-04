package me.xii69.justonemore;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.ServerPing;
import org.slf4j.Logger;

@Plugin(
        id = "justonemore",
        name = "JustOneMore",
        version = "1.0.0",
        description = "JustOneMore plugin for Velocity",
        authors = {"xii69"}
)

public class JustOneMore {

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public JustOneMore(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, this);
    }

    @Subscribe
    public void onProxyPing(ProxyPingEvent event) {
        ServerPing serverPing = event.getPing();
        if (serverPing.getPlayers().isPresent()) {
            int onlinePlayers = serverPing.getPlayers().get().getOnline();
            ServerPing.Players pingPlayers = new ServerPing.Players(onlinePlayers, onlinePlayers + 1, serverPing.asBuilder().getSamplePlayers());
            event.setPing(
                    new ServerPing(
                            serverPing.getVersion(),
                            pingPlayers,
                            serverPing.getDescriptionComponent(),
                            serverPing.getFavicon().orElse(null)
                    )
            );
        }
    }

}
