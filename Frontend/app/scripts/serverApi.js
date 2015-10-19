function ServerApi($http) {

  var mainUrl = 'http://localhost:3000';

  this.getPlayers = function() {
    return $http.get(getFullUrl('/players'))
  };

  this.createPlayer = function(params) {
    return $http.post(getFullUrl('/players'), params)
  };

  this.editPlayer = function(id) {
    return $http.get(getFullUrl('/players/' + id + '/edit'))
  };

  this.updatePlayer = function(id, params) {
    return $http.put(getFullUrl('/players/' + id), params)
  };

  this.getTeams = function() {
    return $http.get(getFullUrl('/teams'))
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

  function getFullUrl(path) {
    return mainUrl + path
  }
}
