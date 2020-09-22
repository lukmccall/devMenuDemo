// Copyright 2015-present 650 Industries. All rights reserved.

import EXDevMenuInterface

@objc(CustomDevMenuExtension)
open class CustomDevMenuExtension: NSObject, RCTBridgeModule, DevMenuExtensionProtocol {
  public static func moduleName() -> String! {
    return "CustomDevMenuExtension"
  }
  
  @objc
  open func devMenuItems() -> [DevMenuItem]? {
    let clearNSUserDefaultsOnPress = {
      let prefs = UserDefaults.standard
      prefs.removeObject(forKey: "key_to_remove")
    }
    
    let clearNSUserDefaults = DevMenuAction(withId: "clear_nsusersdefaults", action: clearNSUserDefaultsOnPress)
    clearNSUserDefaults.label = { "Clear NSUserDefaults" }
    clearNSUserDefaults.glyphName = { "delete" }
    clearNSUserDefaults.importance = DevMenuItem.ImportanceHigh
    clearNSUserDefaults.registerKeyCommand(input: "p", modifiers: .command)
    
    return [clearNSUserDefaults]
  }
}
