package com.jasperb.rougelikegame.view

import com.jasperb.rougelikegame.GameConfig
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.mvc.base.BaseView

class PlayView : BaseView() {

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

        screen.addComponent(sidebar)
        screen.addComponent(logArea)

    }
}
