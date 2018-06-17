package com.christian.sentimask;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;

import com.christian.sentimask.SMEngine;
import com.christian.sentimask.SMProcessingDetails;

/**
 * This class echoes a string called from JavaScript.
 */
public class SentiMask extends CordovaPlugin {
  
  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    // your init code here
  }
  
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    
    /* ============ SMEngine Functions ============ */
    if (action.equals("SMEngineCreate")) {
      SMEngine engine = new SMEngine();
      callbackContext.success(engine.handle());
      return true;
    }
    
    if (action.equals("SMEngineInitialize")) {
      Object engine = new Object();
      // int result = this.SMEngineInitialize(engine);
      // if (result == 0) {
      //   callbackContext.success("Successful!");
      // } else {
      //   callbackContext.error("Error!");
      // }
      return true;
    }

    if (action.equals("SMEngineStartProcessing")) {
      Object engine = new Object();
      Object target = new Object();
      // int result = this.SMEngineStartProcessing(engine, target);
      // if (result == 0) {
      //   callbackContext.success("Successful!");
      // } else {
      //   callbackContext.error("Error!");
      // }
      return true;
    }
    
    if (action.equals("SMEngineProcessImage")) {
      Object engine = new Object();
      Object image = new Object();
      Object details = new Object();
      // int result = this.SMEngineProcessImage(engine, image, details);
      // if (result == 0) {
      //   callbackContext.success("Successful!");
      // } else {
      //   callbackContext.error("Error!");
      // }
      return true;
    }

    if (action.equals("SMEngineProcessImage")) {
      Object engine = new Object();
      Object image = new Object();
      Object details = new Object();
      // int result = this.SMEngineProcessImage(engine, image, details);
      // if (result == 0) {
      //   callbackContext.success("Successful!");
      // } else {
      //   callbackContext.error("Error!");
      // }
      return true;
    }

    if (action.equals("dispose")) {
      long handle = args[0];
      String className = args[1];

      if (className == 'SMEngine') {
        SMEngine engine = new SMEngine(handle);
        engine.dispose();
      }

      if (className == 'SMProcessingDetails') {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        details.dispose();
      }

      return true;
    }
    /* ============================================ */
    

    /* ======= SMProcessingDetails Functions ======= */
    /* ============================================= */
    
    return false;
  }
  
  static {
    System.loadLibrary("SentiMask");
    System.loadLibrary("gstreamer_android");
    System.loadLibrary("jnidispatch");
    System.loadLibrary("NCore");
    System.loadLibrary("NGui");
    System.loadLibrary("NLicensing");
    System.loadLibrary("NMedia");
    System.loadLibrary("NMediaProc");
    System.loadLibrary("openblas");
  }
}
