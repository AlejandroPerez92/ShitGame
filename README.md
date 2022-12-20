# ShitGame
A simple game written in java for explore TDD
## How it works
The core of the game is the class **Map** it controls a list of players and his position on the map.\
The key of the list is the position of the player format as *x-y* the **x** field match with the width of the map and the **y** match with the height. 
## Rules

- Only is allowed one player in a position.
- The players can't move/create outside the bounds of the map.

## To Do

- Implement a service for kill a player.
- Implement a service for move a player.

# Commands
## Execute test
    ./gradlew test

# Disclaimer
For the moment the application not provide an interface for play the game.\
You only can interact with the game from the tests.
