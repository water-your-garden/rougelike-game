package com.jasperb.rougelikegame.builders

import com.jasperb.rougelikegame.attributes.EntityPosition
import com.jasperb.rougelikegame.attributes.EntityTile
import com.jasperb.rougelikegame.attributes.flags.BlockOccupier
import com.jasperb.rougelikegame.attributes.types.Player
import com.jasperb.rougelikegame.attributes.types.Wall
import com.jasperb.rougelikegame.systems.CameraMover
import com.jasperb.rougelikegame.systems.InputReceiver
import com.jasperb.rougelikegame.systems.Movable
import com.jasperb.rougelikegame.world.GameContext
import org.hexworks.amethyst.api.Entities
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType

fun <T : EntityType> newGameEntityOfType(type: T, init: EntityBuilder<T, GameContext>.() -> Unit) =
        Entities.newEntityOfType(type, init)

object EntityFactory {

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(EntityPosition(), EntityTile(GameTileRepository.PLAYER))
        behaviors(InputReceiver)
        facets(Movable, CameraMover)
    }

    fun newWall() = newGameEntityOfType(Wall) {
        attributes(
                EntityPosition(),
                BlockOccupier,
                EntityTile(GameTileRepository.WALL)
        )
    }
}