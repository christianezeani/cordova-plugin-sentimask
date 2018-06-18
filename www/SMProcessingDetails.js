const exec = require('cordova/exec');

const Config = require('./SMConfig');
const SMBase = require('./SMBase');

class SMProcessingDetails extends SMBase {

  getObjectSpaceShapePoint3Count() {
    let point3Count = 0;

    exec((count) => {
      point3Count = count;
    }, (error) => {
      console.error(error);
    }, Config.name, 'SMProcessingDetailsGetObjectSpaceShapePoint3Count', [this.handle]);

    return point3Count;
  }

  getObjectSpaceShapePoint3(index) {
    return new Promise((resolve, reject) => {
      exec(resolve, reject, Config.name, 'SMProcessingDetailsGetObjectSpaceShapePoint3', [this.handle, index]);
    });
  }

  
  getImageSpaceShapePoint3Count() {
    let point3Count = 0;

    exec((count) => {
      point3Count = count;
    }, (error) => {
      console.error(error);
    }, Config.name, 'SMProcessingDetailsGetImageSpaceShapePoint3Count', [this.handle]);

    return point3Count;
  }

  getImageSpaceShapePoint3(index) {
    return new Promise((resolve, reject) => {
      exec(resolve, reject, Config.name, 'SMProcessingDetailsGetImageSpaceShapePoint3', [this.handle, index]);
    });
  }


  getImageSpaceShapePoint2Count() {
    let point2Count = 0;

    exec((count) => {
      point2Count = count;
    }, (error) => {
      console.error(error);
    }, Config.name, 'SMProcessingDetailsGetImageSpaceShapePoint2Count', [this.handle]);

    return point2Count;
  }

  getImageSpaceShapePoint2(index) {
    return new Promise((resolve, reject) => {
      exec(resolve, reject, Config.name, 'SMProcessingDetailsGetImageSpaceShapePoint2', [this.handle, index]);
    });
  }

  getLandmarkCount() {
    let landmarkCount = 0;

    exec((count) => {
      landmarkCount = count;
    }, (error) => {
      console.error(error);
    }, Config.name, 'SMProcessingDetailsGetLandmarkCount', [this.handle]);

    return landmarkCount;
  }

  getLandmark() {
    return new Promise((resolve, reject) => {
      exec(resolve, reject, Config.name, 'SMProcessingDetailsGetLandmark', [this.handle, index]);
    });
  }


  getExpression() {
    let expression = 0;

    exec((pExpression) => {
      expression = pExpression;
    }, (error) => {
      console.error(error);
    }, Config.name, 'SMProcessingDetailsGetExpression', [this.handle]);

    return expression;
  }

  getPoseParameter() {
    let poseParam = 0;

    exec((params) => {
      poseParam = params;
    }, (error) => {
      console.error(error);
    }, Config.name, 'SMProcessingDetailsGetPoseParameter', [this.handle]);

    return poseParam;
  }

  getFaceDetected() {
    let faceDetected = false;

    exec((detected) => {
      faceDetected = detected;
    }, (error) => {
      console.error(error);
    }, Config.name, 'SMProcessingDetailsGetFaceDetected', [this.handle]);

    return faceDetected;
  }

}

module.exports = SMProcessingDetails;
