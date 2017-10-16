'use strict';

angular.module('myApp.NewOrderPage', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/NewOrderPage', {
    templateUrl: 'NewOrderPage/NewOrderPage.html',
    controller: 'NewOrderPageCtrl'
  });
}])

.controller('NewOrderPageCtrl', ['$rootScope', '$scope', 'customerOrders', 'customerProducts', 'customer','$http','$resource', '$location', function ($rootScope, $scope, customerOrders, customerProducts, customer, $http, $resource, $location) {


        $scope.products=[];
        $scope.details=[];
        $scope.deliveryAddress=0;
        $scope.maxQuantity=0;
        $scope.productSelected=null;
        $scope.quantity=0;
        $scope.orderDetails=[];
        customerProducts.get({customerId:""+$rootScope.customerIdSession})
                .$promise.then(
                        //success
                        function( value ){
                            for(var i=0;i<value.length; i++){
                                $scope.products.push(value[i]);
                            }
                        },
                        //error
                        function( error ){
                            alert("Somethign went wrong loading the customer products");
                        }
                );
        $scope.addProduct=function(){
            $scope.orderDetail=null;
            $scope.maxQuantity+=$scope.quantity;
            if($scope.maxQuantity>5){
                alert("The maximum of products is five");
                $scope.maxQuantity-=$scope.quantity;
            }else if($scope.quantity>5||$scope.quantity<1||$scope.quantity==null){
               alert("Pleas enter a validate quantity for this product");
            }else if($scope.productSelected==null){
                alert("Pleas select a product");
            }else{
                for(var i=0;i<$scope.products.length; i++){
                    if($scope.products[i].name==$scope.productSelected){$scope.product=$scope.products[i];}
                }
                $scope.price=parseInt($scope.product.price)*parseInt($scope.quantity);
                $scope.orderDetail={productDescription:$scope.quantity +" x "+$scope.productSelected,price:$scope.price};
                $scope.orderDetails.push($scope.orderDetail);
            }

        }
        $scope.deleteProduct=function(productDescription){
            for(var i=0;i<$scope.orderDetails.length; i++){
                if($scope.orderDetails[i].productDescription==productDescription){
                    $scope.maxQuantity-= parseInt($scope.orderDetails[i].productDescription.substr(0,1));
                    $scope.orderDetails.splice(i,1);
                }
            }
        }
        $scope.addOrder=function(){
            if($scope.orderDetails.length==0){
                alert("Please select at least one product");
            }else if($scope.deliveryAddress==0){
                alert("Please enter the delivery address for the order");
            }else{
                $scope.totalPrice=0;
                for(var i=0;i<$scope.orderDetails.length; i++){
                    $scope.totalPrice+=parseInt($scope.orderDetails[i].price);
                }
                alert("The total price is: "+$scope.totalPrice);
                $scope.customer=null;
                customer.get({customerId:""+$rootScope.customerIdSession})
                    .$promise.then(
                            //success
                            function( value ){
                                $scope.customer={customerId:value.customerId,name:value.name,email:value.email};
                                $scope.creationDate=new Date();
                                $scope.order={customer: $scope.customer, deliveryAddress: $scope.deliveryAddress, creationDate: $scope.creationDate.getTime(),orderDetails: $scope.orderDetails};
                                customerOrders.save({customerId:""+$rootScope.customerIdSession},$scope.order)
                                        .$promise.then(
                                            //success
                                            function(value){
                                                alert("Your order was successfully saved!");
                                            },
                                            //error
                                            function( error ){
                                                console.log("The order could not be saved");
                                            }

                                        );
                            },
                            //error
                            function( error ){
                                alert("Somethign went wrong loading the customer");
                            }
                    );
            }

        }


}]);