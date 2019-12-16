package com.vitroop.blank.ui.catalog

import assertk.assert
import com.nhaarman.mockito_kotlin.verify
import com.virtroop.blank.ui.catalog.CatalogActivity
import com.virtroop.blank.ui.catalog.CatalogContract
import com.vitroop.blank.base.BaseActivityTest
import com.vitroop.blank.common.extensions.hasText
import kotlinx.android.synthetic.main.activity_catalog.*
import org.junit.Test
import org.mockito.Mock

class CatalogActivityTest : BaseActivityTest() {

  @Mock
  lateinit var mockPresenter: CatalogContract.Presenter

  @Test
  fun testOnCreateInteractions() = withActivity<CatalogActivity> {
    verify(mockPresenter).calculateHello()
  }

  @Test
  fun testSayHello() = withActivity<CatalogActivity> {
    it.a_catalog_hello.text = ""

    it.sayHello(TEST_HELLO)

    assert(it.a_catalog_hello).hasText(TEST_HELLO)
  }

  private companion object {
    private const val TEST_HELLO = "TEST_HELLO"
  }
}
