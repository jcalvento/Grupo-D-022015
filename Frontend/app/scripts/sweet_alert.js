function SweetAlert($window, $q) {

  this.displayErrorMessage = function (message) {
    $window.swal({
      title: "",
      text: message,
      type: "error",
      confirmButtonClass: "btn-danger",
      confirmButtonText: "OK"
    });
  };

  this.showWarning = function (message) {
    $window.swal({
      title: "We are sorry!",
      text: message,
      type: "warning",
      confirmButtonColor: "#f69322",
      confirmButtonText: "OK"
    });
  };

  this.askForConfirmation = function (message) {
    var deferred = $q.defer();

    $window.swal({
      title: "Are you sure?",
      text: message,
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#f69322",
      confirmButtonText: "Yes",
      cancelButtonText: "No"
    }, function (isConfirm) {
      if (isConfirm) {
        deferred.resolve();
      } else {
        deferred.reject();
      }
    });
    return deferred.promise;
  };
}
