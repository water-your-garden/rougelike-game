package com.jasperb.rougelikegame.attributes

import com.jasperb.rougelikegame.commands.EntityAction
import com.jasperb.rougelikegame.extensions.GameEntity
import com.jasperb.rougelikegame.world.GameContext
import org.hexworks.amethyst.api.Attribute
import org.hexworks.amethyst.api.entity.EntityType
import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

class EntityActions(private vararg val actions: KClass<out EntityAction<out EntityType, out EntityType>>) : Attribute {

    fun createActionsFor(context: GameContext, source: GameEntity<EntityType>, target: GameEntity<EntityType>):
            Iterable<EntityAction<out EntityType, out EntityType>> {
        return actions.map {
            try {
                it.constructors.first().call(context, source, target)
            } catch (e: Exception) {
                throw IllegalArgumentException("Can't create EntityAction. Does it have the proper constructor?")
            }
        }
    }
}