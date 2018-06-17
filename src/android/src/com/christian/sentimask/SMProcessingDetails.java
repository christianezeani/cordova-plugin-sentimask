package com.christian.sentimask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.christian.sentimask.SMBase;
import com.christian.sentimask.SMPointF;
import com.christian.sentimask.SMPoint3F;


/**
 *  This class is for SentiMask Processing Details
 */
public class SMProcessingDetails extends SMBase {

  public SMProcessingDetails() {
    this.SMProcessingDetailsCreate();
  }

  public SMProcessingDetails(long handle) {
    super(handle);
  }

  public native int getObjectSpaceShapePoint3Count();
  public native SMPoint3F getObjectSpaceShapePoint3(int index);

  public native int getImageSpaceShapePoint3Count();
  public native SMPoint3F getImageSpaceShapePoint3(int index);

  public native int getImageSpaceShapePoint2Count();
  public native SMPointF getImageSpaceShapePoint2(int index);

  public native int getLandmarkCount();
  public native SMPointF getLandmark(int index);

  public native double getExpression();
  public native double getPoseParameter();
  public native boolean getFaceDetected();

  private native boolean SMProcessingDetailsCreate();
  
}
