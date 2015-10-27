function HttpErrorsInterceptor($q, SweetAlert) {

  return {
    'responseError': function(rejection) {
      return interceptError(rejection)
    },

    'requestError': function(rejection) {
      return interceptError(rejection)
    }
  };

  function interceptError(rejection) {
    if(!rejection.data || !rejection.data.error) {
      SweetAlert.showWarning(
        "We have encountered an error in processing your request and are " +
        "unable to proceed. Please try again later."
      );
    } else {
      SweetAlert.displayErrorMessage(rejection.data.error);
    }

    return $q.reject(rejection);
  }

}
