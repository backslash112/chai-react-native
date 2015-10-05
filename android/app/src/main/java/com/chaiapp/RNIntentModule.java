package com.chaiapp;

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
 * created by Wingie;
 * this module will be used to throw intents into the android system;
 * right now this will open a yotube video when clicked
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
  public void intent_youtube(ReadableMap options) {
      // Log.e("CHAI",options.getString("msg"));
      Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("vnd.youtube://" + options.getString("url")));
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(i);
  }
}
