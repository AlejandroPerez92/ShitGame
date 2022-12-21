package org.alex92.error;

public class PlayerNotFoundError extends Exception{
    public PlayerNotFoundError(int x, int y) {
        super(String.format("Player in position x: %d, y: %d not found", x, y));
    }
}
