package com.jasperb.rougelikegame.view

import com.jasperb.rougelikegame.GameConfig
import com.jasperb.rougelikegame.blocks.GameBlock
import com.jasperb.rougelikegame.world.Game
import com.jasperb.rougelikegame.world.GameBuilder
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.GameComponents
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.game.ProjectionMode
import org.hexworks.zircon.api.mvc.base.BaseView

class PlayView(private val game: Game = GameBuilder.defaultGame()) : BaseView() {

    override val theme = GameConfig.THEME

    override fun onDock() {
        super.onDock()

        val sidebar = Components.panel()
                .withSize(GameConfig.SIDEBAR_WIDTH, GameConfig.WINDOW_HEIGHT)
                .wrapWithBox()
                .build()

        val logArea = Components.logArea()
                .withTitle("Log")
                .wrapWithBox()
                .withSize(GameConfig.WINDOW_WIDTH - GameConfig.SIDEBAR_WIDTH, GameConfig.LOG_AREA_HEIGHT)
                .withAlignmentWithin(screen, ComponentAlignment.BOTTOM_RIGHT)
                .build()

        val gameComponent = GameComponents.newGameComponentBuilder<Tile, GameBlock>()
                .withGameArea(game.world)
                .withVisibleSize(game.world.visibleSize())
                .withProjectionMode(ProjectionMode.TOP_DOWN)
                .withAlignmentWithin(screen, ComponentAlignment.TOP_RIGHT)
                .build()

        screen.addComponent(sidebar)
        screen.addComponent(logArea)
        screen.addComponent(gameComponent)

    }
}
