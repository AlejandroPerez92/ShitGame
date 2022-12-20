package org.alex92.entity;

import org.alex92.error.PlayerInPositionError;
import org.alex92.error.PlayerOutsideMapError;

import java.util.Collections;
import java.util.HashMap;

public class Map {
    private int maxWidth;
    private int maxHeight;

    private HashMap<String, Player> players;

    public Map(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.players = new HashMap<>();
    }

    public int getMaxPlayerId() {
        int lastId = -1;

        for (Player player : players.values()) {
            if (player.id() > lastId) {
                lastId = player.id();
            }
        }

        return lastId;
    }

    public void addPlayer(int x, int y, Player player) throws PlayerInPositionError, PlayerOutsideMapError {
        String key = this.generateKeyPosition(x, y);
        this.guardPositionOutsideMap(x, y);
        this.guardPositionOccupied(x, y);
        this.players.put(key, player);
    }

    public java.util.Map<String, Player> players() {
        return Collections.unmodifiableMap(players);
    }

    private String generateKeyPosition(int x, int y) {
        return String.format("%d-%d", x, y);
    }

    private void guardPositionOutsideMap(int x, int y) throws PlayerOutsideMapError {
        if (x < 0 || x > this.maxWidth) {
            throw new PlayerOutsideMapError(x, y);
        }

        if (y < 0 || y > this.maxHeight) {
            throw new PlayerOutsideMapError(x, y);
        }
    }

    private void guardPositionOccupied(int x, int y) throws PlayerInPositionError {
        String key = this.generateKeyPosition(x, y);

        if (this.players.containsKey(key)) {
            throw new PlayerInPositionError(x, y);
        }
    }
}
