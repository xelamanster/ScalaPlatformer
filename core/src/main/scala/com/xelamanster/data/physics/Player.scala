package com.xelamanster.data.physics

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.{Input, Gdx}
import com.badlogic.gdx.math.Vector2
import com.uwsoft.editor.renderer.components.TransformComponent
import com.uwsoft.editor.renderer.scripts.IScript
import com.uwsoft.editor.renderer.utils.ComponentRetriever

class Player extends IScript {
  var entity: Entity = null
  var transformation: TransformComponent = null
  var speed = new Vector2(10, 0)
  val gravity = -100
  val jumpSpeed = 20

  override def init(entity: Entity): Unit = {
    this.entity = entity
    transformation = ComponentRetriever.get(entity, classOf[TransformComponent])
  }

  override def dispose(): Unit = {}

  override def act(delta: Float): Unit = {
    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      transformation.x -= speed.x * delta
      transformation.scaleX = -1
    }

    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      transformation.x += speed.x * delta
      transformation.scaleX = 1
    }

    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
      speed.y = jumpSpeed
    }

    speed.y += gravity * delta
    transformation.y += speed.y * delta

    if (transformation.y < 1f) {
      speed.y = 0
      transformation.y = 1f
    }
  }
}
