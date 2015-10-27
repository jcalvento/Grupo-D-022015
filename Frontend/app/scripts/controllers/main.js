function MainController($scope, $translate) {

  $scope.changeLanguage = function (langKey) {
    $translate.use(langKey);
  };

}
