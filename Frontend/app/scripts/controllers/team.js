function TeamsController($scope, $location, $routeParams, ServerApi) {

  $scope.index = function() {
    ServerApi.getTeams().then(function(response) {
      $scope.teams = response.data.teams
    })
  };

  $scope.create = function() {
    ServerApi.createTeam(teamParams()).then(redirectToIndex())
  };

  $scope.edit = function() {
    ServerApi.editTeam(teamId()).then(function(response) {
      $scope.team = response.data.team
    })
  };

  $scope.update = function() {
    ServerApi.updateTeam($scope.team.id, teamParams()).then(redirectToIndex())
  };

  $scope.delete = function(id) {
    ServerApi.deleteTeam(id).then(function(response) {
      $scope.teams = response.data.teams
    })
  };

  $scope.getAvailablePlayers = function() {
    ServerApi.getAvailablePlayers(teamId()).then(function(response) {
      $scope.players = response.data.players
    })
  };

  $scope.addPlayer = function(id) {
    ServerApi.addPlayer(id, teamId()).then(function(response) {
      $scope.players = response.data.players
    })
  };

  $scope.removePlayer = function(id) {
    ServerApi.removePlayer(id, teamId()).then(function(response) {
      $scope.team = response.data.team
    })
  };

  function teamId() {
    return $routeParams.id
  }

  function redirectToIndex() {
    $location.path('/teams')
  }

  function teamParams() {
    return {
      team: {
        name: $scope.team.name,
        logo: $scope.team.logo
      }
    }
  }

}
