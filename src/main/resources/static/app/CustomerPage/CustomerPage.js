'use strict';

angular.module('myApp.CustomerPage', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CustomerPage', {
    templateUrl: 'CustomerPage/CustomerPage.html',
    controller: 'CustomerPageCtrl'
  });
}])

.controller('CustomerPageCtrl', ['$rootScope', '$scope', 'customerOrders','$http','$resource', '$location', function ($rootScope, $scope, customerOrders, $http, $resource, $location) {

        $scope.orders=[];

        $scope.start=null;
        $scope.end=null;
        $scope.clean=false;
        $scope.filter= function(){
            $scope.clean=true;
            for(var n=0; n<$scope.orders.length; n++){
                if(!($scope.orders[n].creationDate>=$scope.start&&$scope.orders[n].creationDate<=$scope.end)){
                    $scope.orders.splice(n,1);
                }

            }
        };

        $scope.areOrders=false;

        $scope.loadData=function(){
            $scope.clean=false;
            customerOrders.get({customerId:""+$rootScope.customerIdSession})
                .$promise.then(
                        //success
                        function( value ){
                            if(value.length==0){
                                $scope.areOrders=true;
                            }else{
                                value.orderByDate("date", -1);
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
                                        date:value[i].creationDate,
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
                            alert("Error");
                        }
                );

        }



        $scope.loadData();

        Array.prototype.orderByDate=function(p,so){
          if(so!=-1&&so!=1)so=1;
          this.sort(function(a,b){
            var da=new Date(a[p]),db=new Date(b[p]);
            return(da-db)*so;
          })
        };

}]);