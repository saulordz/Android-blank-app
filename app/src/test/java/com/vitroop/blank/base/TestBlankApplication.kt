package com.vitroop.blank.base

import com.virtroop.blank.BlankApplication
import org.robolectric.shadows.ShadowLog
import toothpick.config.Module
import toothpick.smoothie.module.SmoothieApplicationModule

class TestBlankApplication : BlankApplication() {

  init {
    ShadowLog.setupLogging()
  }

  override val modules: Array<Module>
    get() = arrayOf(SmoothieApplicationModule(this))
}
