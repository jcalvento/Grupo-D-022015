function RoundsController($scope, $location, ServerApi) {

  $scope.getPlayers = function() {
    ServerApi.getPlayers().then(function(response) {
      $scope.players = response.data.players
    })
  };

  $scope.redirectToIndex = function() {
    $location.path('/updateRound')
  };
}
