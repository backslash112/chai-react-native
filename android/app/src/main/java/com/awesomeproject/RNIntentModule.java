package com.awesomeproject;

import android.content.Intent;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.Callback;

/**
 * {@link NativeModule} that allows JS to open emails sending apps chooser.
 */

public class RNIntentModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;
  private static final String TAG = "RNIntent";

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
      Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("vnd.youtube://" + Uri.parse(options.getString("url"))) );
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(i);
  }
}