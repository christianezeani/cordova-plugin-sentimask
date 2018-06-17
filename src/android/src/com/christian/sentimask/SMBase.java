package com.christian.sentimask;

/**
 * Base Class for SMEngine and SMProcessingDetails
 */
public class SMBase {

  protected long nativeHandle;

  public SMBase() {  }

  public SMBase(long handle) {
    nativeHandle = handle;
  }

  public long handle() {
    return nativeHandle;
  }

  public native void dispose();
  
}
