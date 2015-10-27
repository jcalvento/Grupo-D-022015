function configuration($httpProvider, $routeProvider, $translateProvider) {
  routes($routeProvider);
  translations($translateProvider);
  $httpProvider.defaults.useXDomain = true;
}
