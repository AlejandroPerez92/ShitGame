package org.alex92.error;

public class PlayerInPositionError extends Exception {
    public PlayerInPositionError(int x, int y) {
        super(String.format("A player is already in position x: %d, y: %d", x, y));
    }
}
