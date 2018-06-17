package com.christian.sentimask;

import com.christian.sentimask.SMBase;
import com.christian.sentimask.SMProcessingDetails;

/**
 * SentiMask Engine
 */
public class SMEngine extends SMBase {

  private long nativeImageHandle;
  private long nativeDetailsHandle;

  public SMEngine() {
    this.SMEngineCreate();
    this.SMEngineInitialize();
  }

  public SMEngine(long handle) {
    super(handle);
  }

  public SMProcessingDetails processImage() {
    SMProcessingDetails pDetails = new SMProcessingDetails();
    boolean success = SMEngineProcessImage(0, pDetails.handle());
    if (success) return pDetails;
    return null;
  }

  public native boolean startProcessing(Object target);
  public native boolean stopProcessing();

  private native boolean SMEngineCreate();
  private native boolean SMEngineInitialize();
  private native boolean SMEngineProcessImage(long hImage, long hDetails);
  
}
