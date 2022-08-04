package me.xii69.justonemore;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.server.ServerPing;
import com.velocitypowered.api.util.Favicon;
import org.slf4j.Logger;

import java.util.Collections;

@Plugin(
        id = "justonemore",
        name = "JustOneMore",
        version = "1.0.0",
        description = "JustOneMore plugin for Velocity",
        authors = {"xii69"}
)

public class JustOneMore {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }

    @Subscribe
    public void onProxyPing(ProxyPingEvent event) {
        Favicon icon = null;
        int players = 0, maxPlayers = 1;
        ServerPing.Players pingPlayers = new ServerPing.Players(players, maxPlayers, Collections.emptyList());
        if (event.getPing().getPlayers().isPresent()) {
            players = event.getPing().getPlayers().get().getOnline();
            maxPlayers = event.getPing().getPlayers().get().getOnline() + 1;
        }
        if (event.getPing().getFavicon().isPresent()) {
            icon = event.getPing().getFavicon().get();
        }
        event.setPing(new ServerPing(event.getPing().getVersion(), pingPlayers, event.getPing().getDescriptionComponent(), icon));
    }

}
