package com.jasperb.rougelikegame.builders

import com.jasperb.rougelikegame.blocks.GameBlock

object GameBlockFactory {

    fun floor() = GameBlock(GameTileRepository.FLOOR)

    fun wall() = GameBlock(GameTileRepository.WALL)
}