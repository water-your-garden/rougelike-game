package com.jasperb.rougelikegame.builders

import org.hexworks.zircon.api.Tiles
import org.hexworks.zircon.api.data.CharacterTile
import org.hexworks.zircon.api.graphics.Symbols

object GameTileRepository {

    val EMPTY: CharacterTile = Tiles.empty()

    val FLOOR: CharacterTile = Tiles.newBuilder()
            .withCharacter('∙')
            .withForegroundColor(GameColours.FLOOR_FOREGROUND)
            .withBackgroundColor(GameColours.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val WALL: CharacterTile = Tiles.newBuilder()
            .withCharacter('#')
            .withForegroundColor(GameColours.WALL_FOREGROUND)
            .withBackgroundColor(GameColours.WALL_BACKGROUND)
            .buildCharacterTile()
}