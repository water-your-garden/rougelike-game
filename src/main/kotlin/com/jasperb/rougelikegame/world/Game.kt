package com.jasperb.rougelikegame.world

import com.jasperb.rougelikegame.attributes.types.Player
import com.jasperb.rougelikegame.extensions.GameEntity

class Game(val world: World,
           val player: GameEntity<Player>) {

    companion object {
        fun create(player: GameEntity<Player>,
                   world: World) = Game(
                world = world,
                player = player
        )
    }
}