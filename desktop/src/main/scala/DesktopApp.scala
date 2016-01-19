package com.xelamanster

import com.badlogic.gdx.backends.lwjgl._
import com.xelamanster.data.SimplePlatformer

object DesktopApp extends App {
    val cfg = new LwjglApplicationConfiguration
    cfg.title = "SimplePlatformer"
    cfg.height = 480
    cfg.width = 800
    cfg.forceExit = false
    new LwjglApplication(new SimplePlatformer, cfg)
}
