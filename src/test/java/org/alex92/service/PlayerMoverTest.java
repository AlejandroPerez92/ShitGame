package org.alex92.service;

import org.alex92.entity.Map;
import org.alex92.entity.Player;
import org.alex92.error.PlayerInPositionError;
import org.alex92.error.PlayerNotFoundError;
import org.alex92.error.PlayerOutsideMapError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerMoverTest {
    private PlayerCreator creator;
    private PlayerMover service;
    private Map map;

    @BeforeEach
    public void setService() {
        this.map = new Map(4, 4);
        this.creator = new PlayerCreator(this.map);
        this.service = new PlayerMover(this.map);
    }

    @Test
    public void GivenPlayerWhenMoveItThenGiveNewPosition() throws Exception {
        Player player = this.creator.execute(1, 2);
        this.service.execute(1,2,2,2);
        Assertions.assertEquals(player, this.map.players().get(String.format("%d-%d", 2, 2)));
    }

    @Test
    public void GivenTwoPlayersWhenMoveOnePlayerToSamePositionWhenMoveThenRiseException() throws Exception {
        Player player1 = this.creator.execute(1, 2);
        Player player2 = this.creator.execute(1, 1);
        Assertions.assertThrows(PlayerInPositionError.class, () -> this.service.execute(1,1,1,2));
    }

    @Test
    public void GivenPlayerWhenMoveItOutsideMapWhenMoveThenRiseException() throws Exception {
        this.creator.execute(1, 2);
        Assertions.assertThrows(PlayerOutsideMapError.class, () -> this.service.execute(1,2,5,5));
    }

    @Test
    public void GivenEmptyMapWhenMovePlayerThenRiseException() throws Exception {
        this.setService();
        Assertions.assertThrows(PlayerNotFoundError.class, () -> this.service.execute(1,2,4,4));
    }
}
