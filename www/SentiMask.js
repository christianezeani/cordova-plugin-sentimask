const SMEngine = require('./SMEngine');

class SentiMask {

  constructor() {  }

  static create() {
    return new SMEngine();
  }

}

module.exports = SentiMask;