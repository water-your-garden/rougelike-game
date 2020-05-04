package com.jasperb.rougelikegame.systems

import com.jasperb.rougelikegame.commands.MoveTo
import com.jasperb.rougelikegame.extensions.GameCommand
import com.jasperb.rougelikegame.world.GameContext
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.Response
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object Movable : BaseFacet<GameContext>() {
    override fun executeCommand(command: GameCommand<out EntityType>) =
            command.responseWhenCommandIs(MoveTo::class) { (context, entity, position) ->
                val world = context.world
                var result: Response = Pass
                if (world.moveEntity(entity, position)) {
                    result = Consumed
                }
                result
            }

}