module.exports = function(grunt) {
  grunt.config.init({
    uglify: {
      options: {
        compress: {
          drop_console: true
        },
        mangle: true
      },
      my_target: {
        options: {
          beautify: false
        },
        files: [{
          expand: true,
          cwd: 'src/js',
          src: '**/*.js',
          dest: 'static/js',
          rename: function (dst, src) {
            return dst + '/' + src.replace('.js', '.min.js');
          }
        }]
      }
    },
    concat: {
      options: {
        separator: '\n\n'
      },
      dist: {
        src: ['static/js/**.min.js', '!static/js/app.min.js'],
        dest: 'static/js/app.min.js'
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.registerTask('default', ['uglify', 'concat']);
};