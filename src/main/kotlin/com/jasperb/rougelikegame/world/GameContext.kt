package com.jasperb.rougelikegame.world

import com.jasperb.rougelikegame.attributes.types.Player
import com.jasperb.rougelikegame.extensions.GameEntity
import org.hexworks.amethyst.api.Context
import org.hexworks.zircon.api.screen.Screen
import org.hexworks.zircon.api.uievent.UIEvent

data class GameContext(val world: World,
                       val screen: Screen,
                       val uiEvent: UIEvent,
                       val player: GameEntity<Player>) : Context