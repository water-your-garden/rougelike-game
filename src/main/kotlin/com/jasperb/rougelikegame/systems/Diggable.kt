package com.jasperb.rougelikegame.systems

import com.jasperb.rougelikegame.commands.Dig
import com.jasperb.rougelikegame.extensions.GameCommand
import com.jasperb.rougelikegame.world.GameContext
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object Diggable : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(Dig::class)
    { (context, _, target) ->
        context.world.removeEntity(target)
        Consumed
    }
}