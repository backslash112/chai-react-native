package com.awesomeproject;

import android.content.Intent;
import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

/**
 * {@link NativeModule} that allows JS to open emails sending apps chooser.
 */

public class RNIntentModule extends ReactContextBaseJavaModule {

    private static final String TAG = "RNIntent";
    ReactApplicationContext reactContext;

    public RNIntentModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNIntent";
    }

    @ReactMethod
    public void mail(ReadableMap options) {
//      Log.v(TAG, "function callllled!");
//      Log.v(TAG, options.getString("url"));
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + Uri.parse(options.getString("url"))));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.reactContext.startActivity(i);
    }
}