var app = angular.module('myApp', []); 

var employeecreate = function($scope,$http) {
    $scope.successMessagebool = false;
    $scope.errorMessagebool = false;
    $scope.Submit =function(){
    	var data = {name: $scope.name,age: $scope.age};
    	$http({
            method : "POST",
            url : "http://localhost:8080/jsonoutput",
            data:JSON.stringify(data)
        }).then(function mySuccess(response) {
        	$scope.successMessage = response.data.output;
            $scope.successMessagebool = true;
            $scope.errorMessagebool = false;
        }, function myError(response) {
        	$scope.errorMessage = response.statusText;
            $scope.errorMessagebool = true;
            $scope.successMessagebool = false;
        });
    }
}
var employeealldata = function($scope,$http) {
	$http({
        method : "GET",
        url : "http://localhost:8080/employeedata"
    }).then(function mySuccess(response) {
    	 $scope.records = response.data.records;
        
    }, function myError(response) {
        $scope.myWelcome = response.statusText;
    });
   
}
app.controller('employeecontroller',employeecreate);
app.controller("myCtrl", employeealldata);

