function TournamentsController($scope, $location, $routeParams, ServerApi, $parse) {

  $scope.csv = {
    content: null,
    header: true,
    headerVisible: true,
    separator: ',',
    separatorVisible: true,
    result: null,
    encoding: 'ISO-8859-1',
    encodingVisible: true,
  };

  $scope.getTournaments = function() {
    $scope.loading = true;
    ServerApi.getTournaments().then(function(response) {
      $scope.tournaments = response.data.tournaments;
      $scope.loading = false;
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
    $scope.loading = true;
    ServerApi.getFixture(tournamentId()).then(function(response) {
      $scope.fixture = response.data.fixture
      $scope.loading = false;
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

  $scope.updateDateMatchResultFromCsv = function() {
    $scope.loading = true;
    ServerApi.postDateMatchResultFromCsv(dateMatchId(), $scope.csv.result).then(processDateMatchResponse)
  };

  $scope.endDateMatch = function(dateMatchId) {
    ServerApi.endDateMatch(dateMatchId).then(function(response) {
      var updatedDateMatch = response.data.date_match;
      $scope.fixture.date_matches.find(function(dateMatch) {
        return dateMatch.id == dateMatchId
      }).ended = updatedDateMatch.ended
    })
  };

  $scope.getDateMatchDetails = function() {
    ServerApi.getDateMatchDetails(dateMatchId()).then(function(response) {
      $scope.matches = response.data.matches;
      $scope.teams = [];
      $scope.matches.map(function(match) {
        $scope.teams.push(match.local);
        $scope.teams.push(match.visitor);
      });
      $scope.playersPoints = response.data.players_points
    })
  };

  $scope.pointsMadeBy = function(aPlayer) {
    return $scope.playersPoints[aPlayer.id]
  };

  $scope.pointsFor = function(aTeam) {
    var match = matchWherePlayed(aTeam);
    return (match.local.id == aTeam.id) ? match.local_points : match.visitor_points
  };

  $scope.rivalOf = function(aTeam) {
    var match = matchWherePlayed(aTeam);
    return (match.local.id != aTeam.id) ? match.local : match.visitor
  };

  $scope.getRanking = function() {
    ServerApi.getRanking(tournamentId()).then(function(response) {
      $scope.ranking = [];
      response.data.ranking.map(function(teamData) {
        $scope.ranking.push({name: teamData[0], points: teamData[1]})
      })
    })
  };

  function matchWherePlayed(aTeam) {
    return $scope.matches.find(function (match) {
      return match.visitor.id == aTeam.id || match.local.id == aTeam.id
    });
  }

  function processDateMatchResponse(response) {
    $scope.goals = response.data.goals;
    $scope.players = response.data.players;
    $scope.loading = false;
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
