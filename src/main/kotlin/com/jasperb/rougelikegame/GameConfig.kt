package com.jasperb.rougelikegame

import org.hexworks.zircon.api.AppConfigs
import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Sizes

object GameConfig {

    val TILESET = CP437TilesetResources.acorn8X16()
    val THEME = ColorThemes.arc()

    const val WINDOW_WIDTH = 80
    const val WINDOW_HEIGHT = 50

    fun buildAppConfig() = AppConfigs.newConfig()
            .enableBetaFeatures()
            .withDefaultTileset(TILESET)
            .withSize(Sizes.create(WINDOW_WIDTH, WINDOW_HEIGHT))
            .build()
}