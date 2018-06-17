const exec = require('cordova/exec');

const Config = require('./SMConfig');
const SMBase = require('./SMBase');
const SMProcessingDetails = require('./SMProcessingDetails');

class SMEngine extends SMBase {
  
  constructor() {
    exec((handle) => {
      super(handle);
    }, (error) => {
      throw xError;
    }, Config.name, 'SMEngineCreate', []);
  }
  
  processImage() {
    return new Promise((resolve, reject) => {
      exec((dHandle) => {
        let pDetails = new SMProcessingDetails(dHandle);
        resolve(pDetails);
      }, reject, Config.name, 'SMEngineProcessImage', [this.handle]);
    });
  }
  
  startProcessing() {
    return new Promise((resolve, reject) => {
      exec(resolve, reject, Config.name, 'SMEngineStartProcessing', [this.handle]);
    });
  }
  
  stopProcessing() {
    return new Promise((resolve, reject) => {
      exec(resolve, reject, Config.name, 'SMEngineStopProcessing', [this.handle]);
    });
  }
  
}

module.exports = SMEngine;
