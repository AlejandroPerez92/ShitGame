package org.alex92.service;

import org.alex92.entity.Map;
import org.alex92.entity.Player;
import org.alex92.error.PlayerInPositionError;
import org.alex92.error.PlayerNotFoudError;
import org.alex92.error.PlayerOutsideMapError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerKillerTest {
    private PlayerKiller service;
    private PlayerCreator creator;
    private Map map;

    @BeforeEach
    public void setService() {
        this.map = new Map(4, 4);
        this.creator = new PlayerCreator(this.map);
        this.service = new PlayerKiller(this.map);
    }

    @Test
    void GivenPlayerInMapWhenKillItThenShouldBeDeleted() throws Exception {
        Player player = this.creator.execute(1, 1);
        this.service.execute(1, 1);
        Assertions.assertNotEquals(player, this.map.players().get(String.format("%d-%d", 1, 1)));
    }

    @Test
    void GivenEmptyMapWhenKillPlayerThenRiseException() throws Exception {
        this.setService();
        Assertions.assertThrows(PlayerNotFoudError.class, () -> this.service.execute(1, 1));
    }

}
