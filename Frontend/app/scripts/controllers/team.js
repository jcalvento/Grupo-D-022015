function TeamsController($scope, $location, $routeParams, ServerApi) {

  $scope.getTeams = function() {
    ServerApi.getTeams().then(function(response) {
      $scope.teams = response.data.teams
    })
  };

  $scope.createTeam = function() {
    ServerApi.createTeam(teamParams()).then(redirectToIndex())
  };

  $scope.editTeam = function() {
    ServerApi.editTeam($routeParams.id).then(function(response) {
      $scope.team = response.data.team;
    })
  };

  $scope.updateTeam = function() {
    ServerApi.updateTeam($scope.team.id, teamParams()).then(redirectToIndex())
  };

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
