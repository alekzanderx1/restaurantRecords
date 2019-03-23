var app = angular.module("worldRestaurant", ['ui.router','ngMaterial','ui.grid']); 

app.config(function($stateProvider,$urlRouterProvider) {
$urlRouterProvider.when('','/home');
var welcomeState = {
  name: 'home',
  url: '/home',
  component:'homestate'
 }

var uploadCsv = {
    name: 'Upload CSV Data',
    url: '/uploadCsv',
	component: 'uploadcsv'
  }

  $stateProvider.state(uploadCsv);
  $stateProvider.state(welcomeState);

});

app.controller('myctrl', function($rootScope){
	
});
