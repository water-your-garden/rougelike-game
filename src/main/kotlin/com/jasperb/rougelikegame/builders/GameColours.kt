package com.jasperb.rougelikegame.builders

import org.hexworks.zircon.api.TileColors

object Palette {
    val VERY_DARK_VIOLET = TileColors.fromString("#17111D")
    val SHADOWY_LAVENDER = TileColors.fromString("#4E4A4E")
    val FLINT = TileColors.fromString("#716E61")
    val REGENT_GREY = TileColors.fromString("#86949F")
    val PEPPERMINT = TileColors.fromString("#D7E7D0")
    val RED_EARTH = TileColors.fromString("#462428")
    val ROOT_BEER = TileColors.fromString("#814D30")
    val FADED_RED = TileColors.fromString("#D3494E")
    val BRONZE = TileColors.fromString("#CD7F32")
    val BIRTHDAY_SUIT = TileColors.fromString("#D4A798")
    val BANANA = TileColors.fromString("#E3CF57")
    val DEEP_KOAMARU = TileColors.fromString("#333366")
    val CADET_BLUE = TileColors.fromString("#7AC5CD")
    val HUNTER_GREEN = TileColors.fromString("#215E21")
    val LEAF = TileColors.fromString("#71AA34")
}

object GameColours {
    val FLOOR_FOREGROUND = Palette.FLINT
    val FLOOR_BACKGROUND = Palette.VERY_DARK_VIOLET

    val WALL_FOREGROUND = Palette.FLINT
    val WALL_BACKGROUND = Palette.SHADOWY_LAVENDER

    val ACCENT_COLOUR = Palette.BANANA
}
