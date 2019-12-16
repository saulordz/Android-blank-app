package com.virtroop.blank.base

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.virtroop.blank.di.ActivityModule
import com.virtroop.blank.di.Scopes
import com.virtroop.blank.ui.catalog.CatalogModule
import toothpick.Scope
import toothpick.Toothpick
import toothpick.smoothie.module.SmoothieActivityModule

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> :
  MvpActivity<V, P>(), MvpView, BaseContract.View {

  private lateinit var scope: Scope

  override fun onCreate(savedInstanceState: Bundle?) {
    initializeToothpick()
    super.onCreate(savedInstanceState)
  }

  override fun onDestroy() {
    Toothpick.closeScope(this)

    super.onDestroy()
  }

  abstract fun addModules(scope: Scope): Scope

  private fun initializeToothpick() {
    scope = Toothpick.openScopes(Scopes.AppScope::class.java, this)
    scope.installModules(SmoothieActivityModule(this), ActivityModule(), CatalogModule())
    addModules(scope)
    Toothpick.inject(this, scope)
  }

}
