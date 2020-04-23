package com.jasperb.rougelikegame

import org.hexworks.zircon.api.AppConfigs
import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Sizes

object GameConfig {

    val DUNGEON_LEVELS = 2

    val TILESET = CP437TilesetResources.rogueYun16x16()
    val THEME = ColorThemes.arc()

    const val SIDEBAR_WIDTH = 18
    const val LOG_AREA_HEIGHT = 8

    const val WINDOW_WIDTH = 80
    const val WINDOW_HEIGHT = 50

    val WORLD_SIZE = Sizes.create3DSize(WINDOW_WIDTH - SIDEBAR_WIDTH, WINDOW_HEIGHT - LOG_AREA_HEIGHT, DUNGEON_LEVELS)

    fun buildAppConfig() = AppConfigs.newConfig()
            .enableBetaFeatures()
            .withDefaultTileset(TILESET)
            .withSize(Sizes.create(WINDOW_WIDTH, WINDOW_HEIGHT))
            .build()
}