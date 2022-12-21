package org.alex92.service;

import org.alex92.entity.Map;
import org.alex92.error.PlayerNotFoundError;
import org.alex92.error.PlayerOutsideMapError;

public class PlayerKiller {
    private Map map;

    public PlayerKiller(Map map) {
        this.map = map;
    }

    public void execute(int x, int y) throws PlayerNotFoundError, PlayerOutsideMapError {
        this.map.removePlayer(x, y);
    }
}
