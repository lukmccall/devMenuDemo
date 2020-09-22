package com.devmenudemo.customdevmenuextension

import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager

class CustomDevMenuExtensionPackage : ReactPackage {
  override fun createNativeModules(reactContext: ReactApplicationContext) = listOf(
      CustomDevMenuExtension(reactContext)
  )

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<View, ReactShadowNode<*>>> = listOf()
}
