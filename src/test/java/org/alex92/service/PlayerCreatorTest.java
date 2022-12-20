package org.alex92.service;

import org.alex92.error.PlayerInPositionError;
import org.alex92.entity.Map;
import org.alex92.entity.Player;
import org.alex92.error.PlayerOutsideMapError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerCreatorTest {
    private PlayerCreator service;
    private Map map;

    @BeforeEach
    public void setService() {
        this.map = new Map(4, 4);
        this.service = new PlayerCreator(this.map);
    }

    @Test
    public void GivenEmptyMapWhenAddNewPlayerThenNewPlayerShouldBeAdd() throws Exception {
        Player player = this.service.execute(1, 2);
        Assertions.assertEquals(player, this.map.players().get(String.format("%d-%d", 1, 2)));
    }

    @Test
    public void GivenMapWithPlayerWhenAddNewPlayerToOtherPositionThenNewPlayerShouldBeAdd() throws Exception {
        Player player = this.service.execute(1, 2);
        Player newPlayer = this.service.execute(1, 1);
        Assertions.assertEquals(newPlayer, this.map.players().get(String.format("%d-%d", 1, 1)));
    }

    @Test
    public void GivenMapWithPlayerWhenAddNewPlayerToSamePositionThenExceptionShouldBeThrow() throws Exception {
        this.service.execute(1, 2);
        Assertions.assertThrows(PlayerInPositionError.class, () -> this.service.execute(1, 2));
    }

    @Test
    public void GivenMapWhenAddNewPlayerOutsideXThenExceptionShouldBeThrow() {
        Assertions.assertThrows(PlayerOutsideMapError.class, () -> this.service.execute(5, 2));
    }

}
