package com.jasperb.rougelikegame.commands

import com.jasperb.rougelikegame.extensions.GameCommand
import com.jasperb.rougelikegame.extensions.GameEntity
import com.jasperb.rougelikegame.world.GameContext
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.impl.Position3D

data class MoveTo(override val context: GameContext,
                  override val source: GameEntity<EntityType>,
                  val position: Position3D) : GameCommand<EntityType>