package org.alex92.service;

import org.alex92.error.PlayerInPositionError;
import org.alex92.entity.Map;
import org.alex92.entity.Player;
import org.alex92.error.PlayerOutsideMapError;

public class PlayerCreator {
    private Map map;

    public PlayerCreator(Map map) {
        this.map = map;
    }

    public Player execute(int x, int y) throws PlayerInPositionError, PlayerOutsideMapError {
        int lastId = this.map.getMaxPlayerId();
        Player newPlayer = new Player(lastId + 1);
        this.map.addPlayer(x, y, newPlayer);
        return newPlayer;
    }
}
