package com.jasperb.rougelikegame.view

import com.jasperb.rougelikegame.GameConfig
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.kotlin.onMouseReleased
import org.hexworks.zircon.api.mvc.base.BaseView

class StartView : BaseView() {

    override val theme = GameConfig.THEME

    override fun onDock() {
        super.onDock()

        val message = "Welcome"

        val header = Components.textBox()
                .withAlignmentWithin(screen, ComponentAlignment.CENTER)
                .withContentWidth(message.length)
                .addHeader(message)
                .addNewLine()
                .build()

        val startButton = Components.button()
                .withAlignmentAround(header, ComponentAlignment.BOTTOM_CENTER)
                .withText("Start")
                .wrapSides(false)
                .withBoxType(BoxType.SINGLE)
                .wrapWithShadow()
                .wrapWithBox()
                .build()

        startButton.onMouseReleased {
            replaceWith(PlayView())
            close()
        }

        screen.addComponent(header)
        screen.addComponent(startButton)
    }
}
