package com.devmenudemo.customdevmenuextension

import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.view.KeyEvent
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import expo.interfaces.devmenu.DevMenuExtensionInterface
import expo.interfaces.devmenu.items.DevMenuAction
import expo.interfaces.devmenu.items.DevMenuItem
import expo.interfaces.devmenu.items.DevMenuItemImportance
import expo.interfaces.devmenu.items.KeyCommand

class CustomDevMenuExtension(reactContext: ReactApplicationContext)
  : ReactContextBaseJavaModule(reactContext),
    DevMenuExtensionInterface {

  override fun getName() = "CustomDevMenuExtension"

  override fun devMenuItems(): List<DevMenuItem>? {
    val clearSharedPreferencesOnPress: () -> Unit = {
      reactApplicationContext
          .getSharedPreferences("your.shared.preferences", MODE_PRIVATE)
          .edit()
          .apply {
            remove("key_to_remove")
            Log.i("CustomDevMenuExt", "Remove key from SharedPreferences")
            apply()
          }
    }
    val clearSharedPreferences = DevMenuAction(
        actionId = "clear shared preferences",
        action = clearSharedPreferencesOnPress
    ).apply {
      label = { "Clear shared preferences" }
      glyphName = { "delete" }
      importance = DevMenuItemImportance.HIGH.value
      keyCommand = KeyCommand(KeyEvent.KEYCODE_S)
    }
    return listOf(clearSharedPreferences)
  }
}
