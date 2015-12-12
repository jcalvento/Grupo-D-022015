function ServerApi($http) {

  var mainUrl = 'http://localhost:3000';
  var options =  { headers: { 'Cache-Control' : 'no-cache' } };

  //Players
  this.getPlayers = function() {
    return $http.get(getFullUrl('/players'), options)
  };

  this.createPlayer = function(params) {
    return $http.post(getFullUrl('/players'), params)
  };

  this.editPlayer = function(id) {
    return $http.get(getFullUrl('/players/' + id + '/edit'))
  };

  this.deletePlayer = function (id) {
    return $http.delete(getFullUrl('/players/' + id))
  };

  this.updatePlayer = function(id, params) {
    return $http.put(getFullUrl('/players/' + id), params)
  };

  //Teams
  this.getTeams = function() {
    return $http.get(getFullUrl('/teams'), options)
  };

  this.createTeam = function(params) {
    return $http.post(getFullUrl('/teams'), params)
  };

  this.editTeam = function(id) {
    return $http.get(getFullUrl('/teams/' + id + '/edit'))
  };

  this.updateTeam = function(id, params) {
    return $http.put(getFullUrl('/teams/' + id), params)
  };

  this.deleteTeam = function(id) {
    return $http.delete(getFullUrl('/teams/' + id))
  };

  this.getAvailablePlayers = function(id) {
    return $http.get(getFullUrl('/teams/' + id + '/players'), options)
  };

  this.addPlayer = function(playerId, teamId) {
    return $http.post(getFullUrl('/teams/' + teamId + '/add_player'), { player_id: playerId })
  };

  this.removePlayer = function(playerId, teamId) {
    return $http.post(getFullUrl('/teams/' + teamId + '/remove_player'), { player_id: playerId })
  };

  //Tournaments
  this.getTournaments = function() {
    return $http.get(getFullUrl('/tournaments'), options)
  };

  this.createTournament = function(params) {
    return $http.post(getFullUrl('/tournaments'), params)
  };

  this.editTournament = function(id) {
    return $http.get(getFullUrl('/tournaments/' + id + '/edit'))
  };

  this.updateTournament = function(id, params) {
    return $http.put(getFullUrl('/tournaments/' + id), params)
  };

  this.getAvailableTeams = function(id) {
    return $http.get(getFullUrl('/tournaments/' + id + '/teams'), options)
  };

  this.addTeam = function(teamId, tournamentId) {
    return $http.post(getFullUrl('/tournaments/' + tournamentId + '/add_team'), { team_id: teamId })
  };

  this.removeTeam = function(teamId, tournamentId) {
    return $http.post(getFullUrl('/tournaments/' + tournamentId + '/remove_team'), { team_id: teamId })
  };

  this.deleteTournament = function(id) {
    return $http.delete(getFullUrl('/tournaments/' + id))
  };

  this.generateFixture = function(id) {
    return $http.get(getFullUrl('/tournaments/' + id + '/generate_fixture'), options)
  };

  this.getFixture = function(tournamentId) {
    return $http.get(getFullUrl('/tournaments/' + tournamentId + '/fixture'), options)
  };

  this.getDateMatchGoals = function(dateMatchId) {
    return $http.get(getFullUrl('/tournaments/' + dateMatchId + '/date_match_goals'), options)
  };

  this.postDateMatchResult = function(dateMatchId, params) {
    return $http.post(getFullUrl('/tournaments/' + dateMatchId + '/date_match_goals'), params)
  };

  this.endDateMatch = function(dateMatchId) {
    return $http.post(getFullUrl('/tournaments/' + dateMatchId + '/end_date_match'))
  };

  this.getDateMatchDetails = function(dateMatchId) {
    return $http.get(getFullUrl('/tournaments/' + dateMatchId + '/date_match_details'))
  };

  this.getRanking = function(tournamentId) {
    return $http.get(getFullUrl('/tournaments/' + tournamentId + '/ranking'))
  };

  function getFullUrl(path) {
    return mainUrl + path
  }
}
