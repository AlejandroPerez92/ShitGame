package org.alex92.error;

public class PlayerNotFoudError extends Exception{
    public PlayerNotFoudError(int x, int y) {
        super(String.format("Player in position x: %d, y: %d not found", x, y));
    }
}
