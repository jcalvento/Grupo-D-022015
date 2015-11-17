'use strict';

var app = angular.module('frontendApp', [
  'ngAnimate',
  'ngCookies',
  'ngResource',
  'ngRoute',
  'ngSanitize',
  'ngTouch',
  'pascalprecht.translate'
  //'willPaginate'
]);

//Controllers
app.controller('MainController', ['$scope', '$translate', MainController]);
app.controller('PlayersController', ['$scope', '$location', '$routeParams', 'ServerApi', '$translate', PlayersController]);
// ['$scope', function($scope) {
//
//  /*
//   This is a sample collection but would typically be returned from a resource.
//   NOTE: I am using camelcase instead of underscores for all the will_paginate
//   variables (e.g. currentPage instead of current_page ).
//   */
//  $scope.willPaginateCollection = {
//    currentPage: 1,
//    perPage: 10,
//    totalEntries: 50,
//    totalPages: 5,
//    offset: 0
//  };
//
//  /*
//   Adding a config object lets you override some of the defaults used
//   within the directive. This is totally optional.
//   */
//  $scope.willPaginateConfig = {
//    previousLabel: 'Past',
//    nextLabel: 'Future'
//  };
//
//  /*
//   You must specify a callback function to handle click events from the
//   paginator.
//   */
//  $scope.getPage = function (page) {
//    console.log(page);
//  };
//}, '$location', '$routeParams', 'ServerApi', '$translate', PlayersController]);
app.controller('TeamsController', ['$scope', '$location', '$routeParams', 'ServerApi', TeamsController]);
app.controller('TournamentsController', ['$scope', '$location', '$routeParams', 'ServerApi', TournamentsController]);
app.controller('RoundsController', ['$scope', '$location', 'ServerApi', RoundsController]);

//Services
app.service('ServerApi',  ['$http', ServerApi]);
app.service('SweetAlert',  ['$window', '$q', SweetAlert]);

app.config(["$httpProvider", "$routeProvider", "$translateProvider", configuration]);
