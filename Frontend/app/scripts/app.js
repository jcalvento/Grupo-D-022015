'use strict';

var app = angular.module('frontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ]);

//Controllers
app.controller('MainController', ['$scope', MainController]);
app.controller('PlayersController', ['$scope', '$location', '$routeParams', 'ServerApi', PlayersController]);
app.controller('TeamsController', ['$scope', '$location', '$routeParams', 'ServerApi', TeamsController]);
app.controller('TournamentsController', ['$scope', 'ServerApi', TournamentsController]);
app.controller('RoundsController', ['$scope', 'ServerApi', RoundsController]);

//Services
app.service('ServerApi',  ['$http', ServerApi]);

app.config(["$httpProvider", "$routeProvider", configuration]);
