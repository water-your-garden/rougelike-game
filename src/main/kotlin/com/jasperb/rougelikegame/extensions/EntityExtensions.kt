package com.jasperb.rougelikegame.extensions

import com.jasperb.rougelikegame.attributes.EntityPosition
import com.jasperb.rougelikegame.attributes.EntityTile
import com.jasperb.rougelikegame.attributes.flags.BlockOccupier
import org.hexworks.amethyst.api.Attribute
import org.hexworks.cobalt.datatypes.extensions.map
import org.hexworks.cobalt.datatypes.extensions.orElseThrow
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.data.impl.Position3D
import kotlin.reflect.KClass

var AnyGameEntity.position : Position3D
    get() = tryToFindAttribute(EntityPosition::class).position
    set(value) {
        findAttribute(EntityPosition::class).map {
            it.position = value
        }
    }

val AnyGameEntity.tile: Tile
    get() = this.tryToFindAttribute(EntityTile::class).tile


fun <T : Attribute> AnyGameEntity.tryToFindAttribute(klass: KClass<T>): T = findAttribute(klass).orElseThrow {
    NoSuchElementException("Entity '$this' has no property with type '${klass.simpleName}'")
}

val AnyGameEntity.occupiesBlock: Boolean
    get() = findAttribute(BlockOccupier::class).isPresent