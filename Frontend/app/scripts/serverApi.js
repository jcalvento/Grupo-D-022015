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

  function getFullUrl(path) {
    return mainUrl + path
  }
}
