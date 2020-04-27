package com.jasperb.rougelikegame.view

import com.jasperb.rougelikegame.GameConfig
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.extensions.onComponentEvent
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed

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
        restartButton.onComponentEvent(ComponentEventType.ACTIVATED) {
            replaceWith(PlayView())
            close()
            Processed
        }

        val quitButton = Components.button()
                .withAlignmentWithin(screen, ComponentAlignment.BOTTOM_RIGHT)
                .withText("Quit")
                .wrapSides(false)
                .wrapWithBox()
                .withBoxType(BoxType.SINGLE)
                .build()
        quitButton.onComponentEvent(ComponentEventType.ACTIVATED) {
            exitProcess(0)
            Processed
        }

        screen.addComponent(header)
        screen.addComponent(restartButton)
        screen.addComponent(quitButton)
    }
}
