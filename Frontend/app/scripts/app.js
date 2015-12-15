'use strict';

var app = angular.module('frontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'pascalprecht.translate',
    'ngCsvImport'
  ]);

//Controllers
app.controller('MainController', ['$scope', '$translate', MainController]);
app.controller('PlayersController', ['$scope', '$location', '$routeParams', 'ServerApi', '$translate', PlayersController]);
app.controller('TeamsController', ['$scope', '$location', '$routeParams', 'ServerApi', TeamsController]);
app.controller('TournamentsController', ['$scope', '$location', '$routeParams', 'ServerApi', '$parse', TournamentsController]);

//Services
app.service('ServerApi',  ['$http', ServerApi]);
app.service('SweetAlert',  ['$window', '$q', SweetAlert]);

app.config(["$httpProvider", "$routeProvider", "$translateProvider", configuration]);
