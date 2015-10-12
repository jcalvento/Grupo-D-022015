'use strict';

angular
  .module('frontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/tournament', {
        templateUrl: 'views/ranking.html',
        controller: 'TournamentCtrl',
        controllerAs: 'tournament'
      })
      .when('/updateRound', {
              templateUrl: 'views/updateRound.html',
              controller: 'UpdateRoundCtrl',
              controllerAs: 'updateRound'
      })
      .when('/updateRoundManually', {
                    templateUrl: 'views/updateRoundManually.html',
                    controller: 'UpdateRoundManuallyCtrl',
                    controllerAs: 'updateRoundManually'
      })
      .when('/updateRoundFromCSV', {
                    templateUrl: 'views/updateRoundFromCSV.html',
                    controller: 'UpdateRoundFromCSVCtrl',
                    controllerAs: 'updateRoundFromCSV'
            })
      .when('/teams', {
        templateUrl: 'views/teams.html',
        controller: 'TeamCtrl',
        controllerAs: 'team'
      })
      .when('/createTeam', {
                    templateUrl: 'views/createTeam.html',
                    controller: 'CreateTeamCtrl',
                    controllerAs: 'createTeam'
                  })
      .when('/editTeam', {
              templateUrl: 'views/editTeam.html',
              controller: 'EditTeamCtrl',
              controllerAs: 'editTeam'
            })
      .otherwise({
        redirectTo: '/'
      });
  });
