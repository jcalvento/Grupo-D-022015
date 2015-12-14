function PlayersController($scope, $location, $routeParams, ServerApi, $translate) {

  $scope.positions = ['Forward', 'Midfield', 'Defender', 'Goalkeeper'];
  $scope.player = { position: $scope.positions[0] };

  $scope.getPlayers = function() {
    ServerApi.getPlayers().then(function(response) {
      $scope.players = response.data.players;
      setNumberOfPages();
    })
  };

  $scope.createPlayer = function() {
    if($scope.newForm.$valid)
      ServerApi.createPlayer(playerParams()).then($scope.redirectToIndex())
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
    if($scope.editForm.$valid)
      ServerApi.updatePlayer($scope.player.id, playerParams()).then($scope.redirectToIndex())
  };

  $scope.redirectToIndex = function() {
    $location.path('/players')
  };

  function playerParams() {
    var position = $scope.player.position;
    if($translate.use() == 'es')
       position = $translate.instant($scope.player.position);

    return {
      player: {
        name: $scope.player.name,
        team: $scope.player.team,
        position: position
      }
    }
  }

  //Pagination
  $scope.goToPage = function(pageNumber) {
    var start = pageNumber * 10;
    var end = (start) + 10;
    $scope.filteredPlayers = $scope.players.slice(start, end);
    $scope.currentPage = pageNumber;
  };

  $scope.goToNextPage = function() {
    if($scope.currentPage != $scope.numberOfPages)
      $scope.goToPage($scope.currentPage + 1)
  };

  $scope.goToPreviousPage = function() {
    if($scope.currentPage != 0)
      $scope.goToPage($scope.currentPage - 1)
  };

  function setNumberOfPages() {
    $scope.numberOfPages = Math.floor($scope.players.length / 10);
    $scope.pages = [];
    for (var i = 0; i <= $scope.numberOfPages; i++)
      $scope.pages.push(i)
    $scope.filteredPlayers = $scope.players.slice(0, 10);
    $scope.currentPage = 0;
  }
}
