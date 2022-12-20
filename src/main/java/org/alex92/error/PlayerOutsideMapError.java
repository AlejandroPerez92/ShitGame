package org.alex92.error;

public class PlayerOutsideMapError extends Exception {
    public PlayerOutsideMapError(int x, int y) {
        super(String.format("The position x: %d, y: %d is outside the map", x, y));
    }
}
