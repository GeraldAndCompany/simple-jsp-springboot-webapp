var path = require('path');

const PATHS = {
  build: path.join(__dirname, 'static', 'js')
};

module.exports = {
  entry: {
    module1: './src/js/module1.js',
    module2: './src/js/module2.js',
    module3: './src/js/module3.js'
  },
  output: {
    path: PATHS.build,
    filename: '[name].min.js'
  }
};