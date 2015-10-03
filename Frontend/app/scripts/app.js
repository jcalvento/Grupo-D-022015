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
        templateUrl: 'views/tournament.html',
        controller: 'TournamentCtrl',
        controllerAs: 'tournament'
      })
      .when('/teams', {
        templateUrl: 'views/teams.html',
        controller: 'TeamCtrl',
        controllerAs: 'team'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
