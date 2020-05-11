package com.jasperb.rougelikegame.commands

import com.jasperb.rougelikegame.extensions.GameEntity
import com.jasperb.rougelikegame.world.GameContext
import org.hexworks.amethyst.api.entity.EntityType

data class Dig(override val context: GameContext,
               override val source: GameEntity<EntityType>,
               override val target: GameEntity<EntityType>) : EntityAction<EntityType, EntityType>