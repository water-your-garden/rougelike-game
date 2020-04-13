package com.jasperb.rougelikegame

import com.jasperb.rougelikegame.view.StartView
import org.hexworks.zircon.api.SwingApplications

fun main(args: Array<String>) {

    val application = SwingApplications.startApplication()
    application.dock(StartView())

}
