function PlayersController($scope, $location, $routeParams, $route, ServerApi) {

  $scope.positions = ['Forward', 'Midfield', 'Defender', 'Goalkeeper'];
  $scope.player = {position: $scope.positions[0]};

  $scope.getPlayers = function() {
    ServerApi.getPlayers().then(function(response) {
      $scope.players = response.data.players
    })
  };

  $scope.createPlayer = function() {
    ServerApi.createPlayer(playerParams()).then(redirectToIndex())
  };

  $scope.edit = function() {
    ServerApi.editPlayer($routeParams.id).then(function(response) {
      $scope.player = response.data.player;
    })
  };

  $scope.delete = function(id) {
    ServerApi.deletePlayer(id).then(function(response) {
      $scope.players = response.data.players
    })
  };

  $scope.update = function() {
    ServerApi.updatePlayer($scope.player.id, playerParams()).then(redirectToIndex())
  };

  function redirectToIndex() {
    $location.path('/players')
  }

  function playerParams() {
    return {
      player: {
        name: $scope.player.name,
        team: $scope.player.team,
        position: $scope.player.position
      }
    }
  }
}
