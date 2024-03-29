package com.vitroop.blank.base

import android.os.Build
import com.virtroop.blank.di.Scopes
import com.vitroop.blank.shadow.ShadowGeocoderLocale
import com.vitroop.blank.shadow.ShadowResourcesCompat
import com.vitroop.blank.shadow.ShadowViewPropertyAnimator
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnit
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowWebView
import toothpick.testing.ToothPickRule

@RunWith(RobolectricTestRunner::class)
@Config(
  application = TestBlankApplication::class,
  minSdk = Build.VERSION_CODES.O_MR1,
  maxSdk = Build.VERSION_CODES.O_MR1,
  shadows = [
    ShadowResourcesCompat::class,
    ShadowFileProvider::class,
    ShadowGeocoderLocale::class,
    ShadowWebView::class,
    ShadowViewPropertyAnimator::class
  ]
)
abstract class BaseRobolectricTest {

  @Rule @JvmField val mockitoRule = MockitoJUnit.rule()
  @Rule @JvmField val appScopeToothpickRule: ToothPickRule = ToothPickRule(this, Scopes.AppScope::class.java)

  val application: TestBlankApplication
    get() = RuntimeEnvironment.application as TestBlankApplication
}
