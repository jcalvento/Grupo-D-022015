function PlayersController($scope, ServerApi) {

  $scope.positions = ['Forward', 'Midfield', 'Defender', 'Goalkeeper'];
  $scope.player = {position: $scope.positions[0]};

  $scope.getPlayers = function() {
    ServerApi.getPlayers().then(function(response) {
      $scope.players = response.data.players
    })
  };

  $scope.createPlayer = function() {
    var params = {
      player: {
        name: $scope.player.name,
        team: $scope.player.team,
        position: $scope.player.position
      }
    };
    ServerApi.createPlayer(params).then(function() {
      window.location = '#/players'
    })
  }
}
