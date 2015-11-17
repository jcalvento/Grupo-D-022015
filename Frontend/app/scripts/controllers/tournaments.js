function TournamentsController($scope, $location, $routeParams, ServerApi) {

  $scope.getTournaments = function() {
    ServerApi.getTournaments().then(function(response) {
      $scope.tournaments = response.data.tournaments
    })
  };

  $scope.create = function() {
    if($scope.newForm.$valid)
      ServerApi.createTournament(tournamentParams()).then($scope.redirectToIndex())
  };

  $scope.delete = function(id) {
    ServerApi.deleteTournament(id).then(function(response) {
      $scope.tournaments = response.data.tournaments
    })
  };

  $scope.editTournament = function() {
    ServerApi.editTournament(tournamentId()).then(function(response) {
      $scope.tournament = response.data.tournament
    })
  };

  $scope.update = function() {
    if($scope.editForm.$valid)
      ServerApi.updateTournament($scope.tournament.id, tournamentParams()).then($scope.redirectToIndex())
  };

  $scope.redirectToIndex = function() {
    $location.path('/tournaments')
  };

  $scope.getAvailableTeams = function() {
    ServerApi.getAvailableTeams(tournamentId()).then(function(response) {
      $scope.teams = response.data.teams
    })
  };

  $scope.addTeam = function(id) {
    ServerApi.addTeam(id, tournamentId()).then(function(response) {
      $scope.teams = response.data.teams
    })
  };

  $scope.removeTeam = function(id) {
    ServerApi.removeTeam(id, tournamentId()).then(function(response) {
      $scope.tournament = response.data.tournament
    })
  };

  $scope.generateFixture = function(tournament) {
    ServerApi.generateFixture(tournament.id).then(function(response) {
      tournament.fixture = response.data.fixture
    })
  };

  $scope.getFixture = function() {
    ServerApi.getFixture(tournamentId()).then(function(response) {
      $scope.fixture = response.data.fixture
    })
  };

  $scope.goBackToEdit = function() {
    $location.path('/tournaments/' + tournamentId() + '/edit')
  };

  $scope.getDateMatchGoals = function() {
    ServerApi.getDateMatchGoals(dateMatchId()).then(processDateMatchResponse)
  };

  $scope.positions = ['Forward', 'Midfield', 'Defender', 'Goalkeeper'];

  $scope.updateDateMatchResult = function() {
    if($scope.goalsForm.$valid)
      ServerApi.postDateMatchResult(dateMatchId(), dateMatchParams()).then(processDateMatchResponse)
  };

  function processDateMatchResponse(response) {
    $scope.goals = response.data.goals;
    $scope.players = response.data.players;
  }

  function dateMatchId() {
    return $routeParams.dateMatchId
  }

  function dateMatchParams() {
    return {
      goal: {
        player_id: $scope.goal.player,
        number_of_goals: $scope.goal.numberOfGoals,
        position: $scope.goal.position
      }
    }
  }

  function tournamentId() {
    return $routeParams.id
  }

  function tournamentParams() {
    return {
      tournament: {
        name: $scope.tournament.name,
        max_amount_of_teams: $scope.tournament.max_amount_of_teams,
        application_deadline: $scope.tournament.application_deadline
      }
    }
  }
}
