class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :null_session, if: Proc.new { |c| c.request.format =~ %r{application/json} }

  before_filter :cors, :set_cache_buster
  rescue_from ActiveRecord::RecordNotFound,
              ActiveRecord::ActiveRecordError,
              with: :handle_error
  rescue_from Exception, with: :log_error

  def cors
    headers['Access-Control-Allow-Origin'] = 'http://localhost:9000'
    headers['Access-Control-Allow-Methods'] = 'POST, PUT, DELETE, GET, OPTIONS'
    headers['Access-Control-Request-Method'] = '*'
    headers['Access-Control-Allow-Headers'] = 'Origin, X-Requested-With, Content-Type, Accept, Authorization, Cache-Control'
  end

  def set_cache_buster
    response.headers['Cache-Control'] = 'no-cache, no-store, max-age=0, must-revalidate'
    response.headers['Pragma'] = 'no-cache'
    response.headers['Expires'] = 'Fri, 01 Jan 1990 00:00:00 GMT'
  end

  def options
    render :json => { }
  end

  def handle_error(exception)
    render json: { error: exception.message }, status: :internal_server_error
  end

  def log_error(exception)
    logger.info 'Exception caught:'
    logger.error "Class: #{exception.class}, Message: #{exception.message}"
    logger.info 'Backtrace:'
    logger.error exception.backtrace.join("\n")
    logger << "\n"

    render json: { }, status: :internal_server_error
  end

  protected

  def logger
    @logger ||= Logger.new("#{Rails.root}/log/#{Rails.env}_errors.log")
  end
end
