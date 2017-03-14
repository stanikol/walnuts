require 'test_helper'
require 'fileutils'
require 'sass'

class CompilationTest < Minitest::Test
  def test_compilation
    path = 'assets/stylesheets'
    %w(_bootstrap bootstrap/_theme).each do |name|
      FileUtils.rm_rf('.sass-cache', secure: true)
      engine = Sass::Engine.for_file("#{path}/#{name}.scss", syntax: :scss, load_paths: [path])
      FileUtils.mkdir_p("tmp/#{File.dirname(name)}")
      File.open("tmp/#{name}.css", 'w') { |f|
        f.write engine.render
      }
      assert true # nothing was raised
    end
  end
end
