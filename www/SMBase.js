const exec = require('cordova/exec');

const Config = require('./SMConfig');

/**
 * Base Class for SMEngne and SMProcessing Details
 */
class SMBase {

  $__handle = null;

  /**
   * Creates a new instance of a Native Object
   * @param {*} handle 
   */
  constructor(handle) {
    if (typeof (handle) !== 'number') throw 'Invalid handle!';
    this.$__handle = handle;
  }

  get handle() {
    return this.$__handle;
  }

  dispose() {
    if (!this.handle) return;
    exec(null, null, Config.name, 'dispose', [
      this.handle,
      this.constructor.name
    ]);
  }

}

module.exports = SMBase;
