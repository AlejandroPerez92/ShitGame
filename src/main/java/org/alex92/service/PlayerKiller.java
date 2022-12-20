package org.alex92.service;

import org.alex92.entity.Map;
import org.alex92.entity.Player;
import org.alex92.error.PlayerInPositionError;
import org.alex92.error.PlayerNotFoudError;
import org.alex92.error.PlayerOutsideMapError;

public class PlayerKiller {
    private Map map;

    public PlayerKiller(Map map) {
        this.map = map;
    }

    public void execute(int x, int y) throws PlayerNotFoudError, PlayerOutsideMapError {
        this.map.removePlayer(x, y);
    }
}
