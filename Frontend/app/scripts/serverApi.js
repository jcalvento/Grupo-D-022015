function ServerApi($http) {

  var mainUrl = 'http://localhost:3000';

  this.getPlayers = function() {
    return $http.get(getFullUrl('/players'))
  };

  this.createPlayer = function(player) {
    return $http.post(getFullUrl('/players'), player)
  };

  function getFullUrl(path) {
    return mainUrl + path
  }
}
