'use strict';

angular.module('myApp.HomePage', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/HomePage', {
    templateUrl: 'HomePage/HomePage.html',
    controller: 'HomePageCtrl'
  });
}])

.controller('HomePageCtrl', ['$rootScope', '$scope', 'customers', 'customer', '$http','$resource', '$location', function ($rootScope, $scope, customers, customer, $http, $resource, $location) {


        $scope.customersNames=[];
        $scope.customerSelected=null;
        customers.get()
            .$promise.then(
                    //success
                    function( value ){
                        for(var i=0;i<value.length; i++){
                            $scope.customersNames.push({customerId:value[i].customerId,name:value[i].name});
                        }
                    },
                    //error
                    function( error ){
                        alert("Something went wrong loading the customers");

                    }
            );

        $scope.customerId=null;
        $scope.nameSelect=false;
        $scope.nameSelected=function(){
               if($scope.customerSelected==null){
                    alert("Please select the customer name");
               }else{
                    $scope.nameSelect=true;
                    $scope.options=[];
                    for(var i=0;i<$scope.customersNames.length; i++){
                        if($scope.customerSelected==$scope.customersNames[i].name){
                               $scope.options.push({customerId:$scope.customersNames[i].customerId,name:$scope.customersNames[i].name});
                        }
                    }
               }

        }
        $scope.goCustomerPage=function(){
            if($scope.customerId==null){
                alert("Please select the customer id");
            }else{
                $rootScope.customerIdSession=$scope.customerId;
                $location.path("CustomerPage");
            }
        }
}]);
