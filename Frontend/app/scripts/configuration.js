function configuration($httpProvider, $routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/main.html',
      controller: 'MainController'
    })
    .when('/tournament', {
      templateUrl: 'views/ranking.html',
      controller: 'TournamentsController'
    })
    .when('/updateRound', {
      templateUrl: 'views/rounds/index.html',
      controller: 'RoundsController'
    })
    .when('/updateRoundManually', {
      templateUrl: 'views/rounds/updateRoundManually.html',
      controller: 'RoundsController'
    })
    .when('/updateRoundFromCSV', {
      templateUrl: 'views/rounds/updateRoundFromCSV.html',
      controller: 'RoundsController'
    })
    .when('/teams', {
      templateUrl: 'views/teams/index.html',
      controller: 'TeamsController'
    })
    .when('/createTeam', {
      templateUrl: 'views/teams/create.html',
      controller: 'TeamsController'
    })
    .when('/editTeam', {
      templateUrl: 'views/teams/edit.html',
      controller: 'TeamsController'
    })
    .when('/players', {
      templateUrl: 'views/players/index.html',
      controller: 'PlayersController'
    })
    .when('/players/new', {
      templateUrl: 'views/players/new.html',
      controller: 'PlayersController'
    })
    .otherwise({
      redirectTo: '/'
    });
  $httpProvider.defaults.useXDomain = true;
}
