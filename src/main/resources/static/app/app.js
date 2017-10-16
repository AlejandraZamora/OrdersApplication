'use strict';

angular.module('myApp', [
  'ngRoute',
  'myApp.template',
  'myApp.HomePage',
  'myApp.CustomerPage',
  'myApp.NewOrderPage',
  'myApp.version',
  'services.factory'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/HomePage'});
}]);

