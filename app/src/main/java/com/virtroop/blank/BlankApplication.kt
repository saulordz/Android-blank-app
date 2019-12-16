package com.virtroop.blank

import android.app.Application
import com.virtroop.blank.di.DataModule
import com.virtroop.blank.di.RxModule
import com.virtroop.blank.di.Scopes
import toothpick.Scope
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.smoothie.module.SmoothieApplicationModule

open class BlankApplication : Application() {

  internal open val modules
    get() = arrayOf(SmoothieApplicationModule(this), RxModule(), DataModule())

  lateinit var scope: Scope

  override fun onCreate() {
    super.onCreate()

    initializeToothpick()
  }

  internal open fun initializeToothpick() {
    val configuration = if (BuildConfig.DEBUG) {
      Configuration.forDevelopment()
    } else {
      Configuration.forProduction()
    }
    Toothpick.setConfiguration(configuration)

    scope = Toothpick.openScope(Scopes.AppScope::class.java)
    scope.installModules(*modules)
    Toothpick.inject(this, scope)
  }
}
