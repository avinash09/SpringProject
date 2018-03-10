var app = angular.module('myApp', []);

app.controller('employeecontroller', function($scope,$http) {
    $scope.Submit =function(){
    	
    	var data = {name: $scope.name,age: $scope.age};
    	$http({
            method : "POST",
            url : "http://localhost:8080/jsonoutput",
            data:JSON.stringify(data)
        }).then(function mySuccess(response) {
            $scope.myWelcome = response.data;
            alert($scope.myWelcome.output);
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });
    }
});
