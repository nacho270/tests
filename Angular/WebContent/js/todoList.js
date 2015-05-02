var todo = angular.module("todo",["LocalStorageModule"]);
todo.controller("TodoController",function($scope,localStorageService){
	if(localStorageService.get("angularTodoList") ){
		$scope.todo = localStorageService.get("angularTodoList");
	}else{
		$scope.todo = [];
	}
	$scope.newActivity = {};
	$scope.addActivity = function(){
		$scope.todo.push($scope.newActivity);
		//localStorageService.set("angularTodoList",$scope.todo);
		$scope.newActivity = {};
	};
	$scope.clearList = function(){
		$scope.todo = [];
		//localStorageService.set("angularTodoList",$scope.todo);
	};
	$scope.$watchCollection("todo",function(newValue, oldValue){
		localStorageService.set("angularTodoList",$scope.todo);
	});
});