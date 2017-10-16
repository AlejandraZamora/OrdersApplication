'use strict';

angular.module('services.factory', ['ngRoute', 'ngResource'])
.factory('customer', function($resource){
	return $resource('/customer/:customerId',{id:"@_customerId"},{get: { method: 'GET'}});
})
.factory('customers', function($resource) {
	return $resource('/customer',{},{ 'get': { method: 'GET', isArray: true}});
})
.factory('customerOrders', function($resource) {
	return $resource('/customer/:customerId/order',{id:"@_customerId"},{'get':{ method: 'GET', isArray: true}});
})
.factory('customerProducts', function($resource) {
  	return $resource('/customer/:customerId/product',{id:"@_customerId"},{'get':{ method: 'GET', isArray: true}});
  })
;
