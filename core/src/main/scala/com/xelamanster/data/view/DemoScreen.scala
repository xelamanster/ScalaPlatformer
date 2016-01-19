package com.xelamanster.data.view

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.{Gdx, Screen}
import com.uwsoft.editor.renderer.SceneLoader
import com.uwsoft.editor.renderer.utils.ItemWrapper
import com.xelamanster.data.SceneSettings
import com.xelamanster.data.physics.Player

class DemoScreen extends Screen {
  val camera = new OrthographicCamera(Gdx.graphics.getWidth, Gdx.graphics.getHeight)
  camera.position.set(Gdx.graphics.getWidth/2, Gdx.graphics.getHeight/2, 0)
  camera.update()

  val mainBatch = new SpriteBatch

  val shapeRenderer = new ShapeRenderer
  shapeRenderer.setProjectionMatrix(camera.combined)

  val viewport = new StretchViewport(SceneSettings.width, SceneSettings.height)

  val sl = new SceneLoader()
  sl.loadScene(SceneSettings.name, viewport)

  val root = new ItemWrapper(sl.getRoot)
  root.getChild(SceneSettings.ObjectsNames.sheep)
    .addScript(new Player)

  def render(delta: Float) = {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    sl.getEngine.update(Gdx.graphics.getDeltaTime)
  }

  def resize(width: Int, height: Int) = {}

  def show() = {}

  def hide() = {}

  def pause() = {}

  def resume() = {}

  def dispose() = {}
}
