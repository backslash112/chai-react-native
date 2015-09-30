package com.awesomeproject;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

public class FBLoginButtonPackage extends MainReactPackage {
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> main = super.createViewManagers(reactContext);
        List<ViewManager> result = new ArrayList<>();
        result.addAll(main);
        result.add(new FBLoginButtonManager());
        return result;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return super.createNativeModules(reactContext);
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return super.createJSModules();
    }
}
