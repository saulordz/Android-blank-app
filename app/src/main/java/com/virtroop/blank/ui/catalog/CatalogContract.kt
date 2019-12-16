package com.virtroop.blank.ui.catalog

import com.virtroop.blank.base.BaseContract

interface CatalogContract {
  interface View : BaseContract.View {
    fun sayHello(result: String)
  }

  interface Presenter : BaseContract.Presenter<View> {
    fun calculateHello()
  }
}
