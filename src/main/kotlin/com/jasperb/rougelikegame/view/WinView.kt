package com.jasperb.rougelikegame.view

import com.jasperb.rougelikegame.GameConfig
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.kotlin.onMouseReleased
import org.hexworks.zircon.api.mvc.base.BaseView
import kotlin.system.exitProcess

class WinView : BaseView() {

    override val theme = GameConfig.THEME

    override fun onDock() {
        super.onDock()

        val message = "You won!"

        val header = Components.header()
                .withAlignmentWithin(screen, ComponentAlignment.CENTER)
                .withText(message)
                .build()

        val restartButton = Components.button()
                .withAlignmentWithin(screen, ComponentAlignment.BOTTOM_LEFT)
                .withText("Restart")
                .wrapSides(false)
                .wrapWithBox()
                .withBoxType(BoxType.SINGLE)
                .build()
        restartButton.onMouseReleased {
            replaceWith(PlayView())
            close()
        }

        val quitButton = Components.button()
                .withAlignmentWithin(screen, ComponentAlignment.BOTTOM_RIGHT)
                .withText("Quit")
                .wrapSides(false)
                .wrapWithBox()
                .withBoxType(BoxType.SINGLE)
                .build()
        quitButton.onMouseReleased {
            exitProcess(0)
        }

        screen.addComponent(header)
        screen.addComponent(restartButton)
        screen.addComponent(quitButton)
    }
}
