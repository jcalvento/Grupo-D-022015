function routes($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/main.html',
      controller: 'MainController'
    })
    .when('/tournament', {
      templateUrl: 'views/ranking.html',
      controller: 'TournamentsController'
    })
    .when('/tournaments', {
      templateUrl: 'views/tournaments/index.html',
      controller: 'TournamentsController'
    })
    .when('/tournaments/new', {
      templateUrl: 'views/tournaments/new.html',
      controller: 'TournamentsController'
    })
    .when('/tournaments/:id/edit', {
      templateUrl: 'views/tournaments/edit.html',
      controller: 'TournamentsController'
    })
    .when('/tournaments/:id/teams', {
      templateUrl: 'views/tournaments/teams.html',
      controller: 'TournamentsController'
    })
    .when('/updateRound', {
      templateUrl: 'views/rounds/index.html',
      controller: 'RoundsController'
    })
    .when('/:id/updateRoundManually', {
      templateUrl: 'views/rounds/updateRoundManually.html',
      controller: 'RoundsController'
    })
    .when('/:id/updateRoundFromCSV', {
      templateUrl: 'views/rounds/updateRoundFromCSV.html',
      controller: 'RoundsController'
    })
    .when('/teams', {
      templateUrl: 'views/teams/index.html',
      controller: 'TeamsController'
    })
    .when('/teams/new', {
      templateUrl: 'views/teams/new.html',
      controller: 'TeamsController'
    })
    .when('/teams/:id/edit', {
      templateUrl: 'views/teams/edit.html',
      controller: 'TeamsController'
    })
    .when('/teams/:id/players', {
      templateUrl: 'views/teams/players.html',
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
    .when('/players/:id/edit', {
      templateUrl: 'views/players/edit.html',
      controller: 'PlayersController'
    })
    .otherwise({
      redirectTo: '/'
    });
}
