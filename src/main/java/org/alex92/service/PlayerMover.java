package org.alex92.service;

import org.alex92.entity.Map;
import org.alex92.error.PlayerInPositionError;
import org.alex92.error.PlayerNotFoundError;
import org.alex92.error.PlayerOutsideMapError;

public class PlayerMover {
    private Map map;

    public PlayerMover(Map map) {
        this.map = map;
    }

    public void execute(int originX, int originY, int destinyX, int destinyY) throws
            PlayerNotFoundError,
            PlayerOutsideMapError,
            PlayerInPositionError
    {
        this.map.movePlayer(originX, originY, destinyX, destinyY);
    }
}
