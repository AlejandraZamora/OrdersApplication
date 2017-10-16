'use strict';

angular.module('myApp.template', ['ngRoute'])

.controller('templateCtrl', ['$rootScope', '$scope', '$location', function ($rootScope, $scope, $location) {


      $scope.goHomePage=function(){
            $location.path("HomePage");
      };
      $scope.goOrdersCustomer=function(){
            $location.path("CustomerPage");
      };
      $scope.goNewOrder=function(){
            $location.path("NewOrderPage");
      };
}]);
