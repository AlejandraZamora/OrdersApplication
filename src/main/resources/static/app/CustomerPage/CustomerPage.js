'use strict';

angular.module('myApp.CustomerPage', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CustomerPage', {
    templateUrl: 'CustomerPage/CustomerPage.html',
    controller: 'CustomerPageCtrl'
  });
}])

.controller('CustomerPageCtrl', ['$rootScope', '$scope', 'customerOrders','$http','$resource', '$location', function ($rootScope, $scope, customerOrders, $http, $resource, $location) {



        $scope.start=null;
        $scope.end=null;
        $scope.clean=false;
        $scope.filter= function(){
            if($scope.end<=$scope.start){
                alert("Pleas choose a valid interval of dates");
            }else{
                $scope.clean=true;
                $scope.index=[];
                for(var n=0; n<$scope.orders.length; n++){
                    if(($scope.orders[n].creationDate>=$scope.start.getTime() && $scope.orders[n].creationDate<=$scope.end.getTime())){
                        $scope.index.push($scope.orders[n]);
                    }

                }$scope.orders=$scope.index;
            }

        };

        $scope.areOrders=false;

        $scope.loadData=function(){
            $scope.orders=[];
            $scope.clean=false;
            customerOrders.get({customerId:""+$rootScope.customerIdSession})
                .$promise.then(
                        //success
                        function( value ){
                            if(value.length==0){
                                $scope.areOrders=true;
                            }else{
                                for(var i=0;i<value.length; i++){
                                    $scope.details=[];
                                    $scope.details=value[i].orderDetails;
                                    $scope.price=0;
                                    $scope.products=[];
                                    for(var j=0;j<$scope.details.length; j++){
                                      $scope.price +=  parseInt($scope.details[i].price);
                                      $scope.products.push({productDescription:$scope.details[i].productDescription});
                                    }
                                    $scope.order={
                                        creationDate:value[i].creationDate,
                                        orderId:value[i].orderId,
                                        deliveryAddress:value[i].deliveryAddress,
                                        price:$scope.price,
                                        products:$scope.products
                                    };
                                    $scope.orders.push($scope.order);
                                }
                            }

                        },
                        //error
                        function( error ){
                            alert("Something went wrong loading the customer orders");
                        }
                );

        }
        $scope.loadData();

}]);