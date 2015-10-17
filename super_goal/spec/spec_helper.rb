is_ide_test_enabled = !!ENV['IDE_TEST']
is_rubymine = ENV['RM_INFO'] && !ENV['RM_INFO'].empty?
is_sublime = false  # use this if you care to setup sublime for ide-test
use_different_test_environment_for_ide_test = is_ide_test_enabled && (is_rubymine || is_sublime)
if use_different_test_environment_for_ide_test
  # use a different test environment, when running from
  ENV['RAILS_ENV'] = 'ide_test'
else
  # default
  ENV['RAILS_ENV'] ||= 'test'
end

require File.dirname(__FILE__) + '/../config/environment'
require 'shoulda/matchers'
require 'timecop'
require 'webmock/rspec'

RSpec.configure do |config|
  config.filter_run_excluding :broken => true
  config.filter_run_excluding :deprecated => true

  config.before(:all) {
    (ActiveRecord::Base.send :descendants).each { |c| c.delete_all }

    # block real web requests but allow for localhost (ajax/capybara)
    WebMock.disable_net_connect!(:allow_localhost => true)
  }

  config.after(:each) do
    Timecop.return
  end

  # == Mock Framework
  #
  # If you prefer to use mocha, flexmock or RR, uncomment the appropriate line:
  #
  # config.mock_with :mocha
  # config.mock_with :flexmock
  # config.mock_with :rr
  config.mock_with :rspec

  # XXX: much better than GC.disable is to add the following environment variables
  # RUBY_FREE_MIN=100000 RUBY_HEAP_MIN_SLOTS=1000000 RUBY_GC_MALLOC_LIMIT=200000000 LD_PRELOAD=/usr/lib/libtcmalloc_minimal.so
  #config.before(:all) { GC.disable }
  #config.after(:all) { GC.enable }

  config.backtrace_exclusion_patterns = [
      /\/lib\d*\/ruby\//,
      /bin\//,
      /gems/,
      /spec\/spec_helper\.rb/,
      /lib\/rspec\/(core|expectations|matchers|mocks)/
  ]

  config.include FactoryGirl::Syntax::Methods
end