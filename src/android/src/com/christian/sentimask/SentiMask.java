package com.christian.sentimask;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;

import com.christian.sentimask.SMEngine;
import com.christian.sentimask.SMProcessingDetails;
import com.christian.sentimask.SMProcessingDetails;
import com.christian.sentimask.SMPointF;
import com.christian.sentimask.SMPoint3F;

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
    
    if (action.equals("SMEngineProcessImage")) {
      long handle = args[0];

      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMEngine engine = new SMEngine(handle);
        SMProcessingDetails details = engine.processImage();
        if (!details) {
          callbackContext.error("Unable to Process Image.");
        } else {
          callbackContext.success(details.handle());
        }
      }

      return true;
    }

    if (action.equals("SMEngineStartProcessing")) {
      long handle = args[0];

      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMEngine engine = new SMEngine(handle);
        if (engine.startProcessing()) {
          callbackContext.success("Image Currently being processed.");
        } else {
          callbackContext.error("Unable to begin image processing.");
        }
      }

      return true;
    }

    if (action.equals("SMEngineStopProcessing")) {
      long handle = args[0];

      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMEngine engine = new SMEngine(handle);
        if (engine.stopProcessing()) {
          callbackContext.success("Image processing stopped.");
        } else {
          callbackContext.error("An error occurred, please try again later.");
        }
      }

      return true;
    }
    /* ============================================ */
    
    
    /* ======= SMProcessingDetails Functions ======= */
    if (action.equals("SMProcessingDetailsGetObjectSpaceShapePoint3Count")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        int count = details.getObjectSpaceShapePoint3Count();
        callbackContext.success(count);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetObjectSpaceShapePoint3")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        SMPoint3F point = details.getObjectSpaceShapePoint3();
        callbackContext.success(point);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetImageSpaceShapePoint3Count")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        int count = details.getImageSpaceShapePoint3Count();
        callbackContext.success(count);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetImageSpaceShapePoint3")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        SMPoint3F point = details.getImageSpaceShapePoint3();
        callbackContext.success(point);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetImageSpaceShapePoint2Count")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        int count = details.getImageSpaceShapePoint2Count();
        callbackContext.success(count);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetImageSpaceShapePoint2")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        SMPointF point = details.getImageSpaceShapePoint2();
        callbackContext.success(point);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetLandmarkCount")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        int count = details.getLandmarkCount();
        callbackContext.success(count);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetLandmark")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        SMPointF mark = details.getLandmark();
        callbackContext.success(mark);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetExpression")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        float expression = details.getExpression();
        callbackContext.success(expression);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetPoseParameter")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        double pParams = details.getPoseParameter();
        callbackContext.success(pParams);
      }
      return true;
    }

    if (action.equals("SMProcessingDetailsGetFaceDetected")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        SMProcessingDetails details = new SMProcessingDetails(handle);
        boolean detected = details.getFaceDetected();
        callbackContext.success(detected);
      }
      return true;
    }
    /* ============================================= */
    

    if (action.equals("dispose")) {
      long handle = args[0];
      if (!handle) {
        callbackContext.error("Invalid Handle!");
      } else {
        String className = args[1];

        if (className == "SMEngine") {
          SMEngine engine = new SMEngine(handle);
          engine.dispose();
        }

        if (className == "SMProcessingDetails") {
          SMProcessingDetails details = new SMProcessingDetails(handle);
          details.dispose();
        }

        callbackContext.success("Objects successfully disposed!");
      }
      SMEngine engine = new SMEngine(handle);
      callbackContext.success(engine.handle());
      return true;
    }
    
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
