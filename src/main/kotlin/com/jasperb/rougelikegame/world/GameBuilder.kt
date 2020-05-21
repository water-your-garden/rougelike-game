package com.jasperb.rougelikegame.world

import com.jasperb.rougelikegame.GameConfig
import com.jasperb.rougelikegame.GameConfig.WORLD_SIZE
import com.jasperb.rougelikegame.attributes.types.Player
import com.jasperb.rougelikegame.builders.EntityFactory
import com.jasperb.rougelikegame.extensions.GameEntity
import org.hexworks.zircon.api.Positions
import org.hexworks.zircon.api.Sizes
import org.hexworks.zircon.api.data.impl.Size3D

class GameBuilder(val worldSize: Size3D = WORLD_SIZE) {

    private val visibleSize = Sizes.create3DSize(
            xLength = GameConfig.WINDOW_WIDTH - GameConfig.SIDEBAR_WIDTH,
            yLength = GameConfig.WINDOW_HEIGHT - GameConfig.LOG_AREA_HEIGHT,
            zLength = 1)

    val world = WorldBuilder(worldSize)
            .makeCaves()
            .build(visibleSize)

    fun buildGame(): Game {
        prepareWorld()

        val player = addPlayer()

        return Game.create(player, world)
    }

    private fun prepareWorld() = also {
        world.scrollUpBy(world.actualSize().zLength)
    }

    private fun addPlayer(): GameEntity<Player> {
        val player = EntityFactory.newPlayer()
        world.addAtEmptyPosition(player,
                offset = Positions.default3DPosition().withZ(GameConfig.DUNGEON_LEVELS - 1),
                size = world.visibleSize().copy(zLength = 0))
        return player
    }

    companion object {
        fun defaultGame() = GameBuilder(worldSize = WORLD_SIZE).buildGame()
    }
}