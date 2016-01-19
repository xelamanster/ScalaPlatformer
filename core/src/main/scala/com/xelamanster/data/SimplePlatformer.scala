package com.xelamanster.data

import com.badlogic.gdx.Game
import com.xelamanster.data.view.DemoScreen

class SimplePlatformer extends Game {
  override def create() {
        setScreen(new DemoScreen)
    }
}
