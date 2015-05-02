var todo = angular.module("todo",["LocalStorageModule"]);
todo.factory('TodoService',function(localStorageService){
	var todoService = {};
	todoService.key = "angularTodoList";
	if(localStorageService.get(todoService.key) ){
		todoService.activities = localStorageService.get(todoService.key);
	}else{
		todoService.activities = [];
	}

	todoService.add = function(newActiv){
		todoService.activities.push(newActiv);
		todoService.updateLocalStorage();
	}
	
	todoService.updateLocalStorage = function(){
		localStorageService.set(todoService.key,todoService.activities);
	}
	
	todoService.clean = function(){
		todoService.activities = [];
		todoService.updateLocalStorage();
		return todoService.getAll();
	}
	
	todoService.getAll = function(){
		return todoService.activities;
	}
	
	todoService.removeItem = function(item){
		todoService.activities = todoService.activities.filter(function(activity){
			return activity !== item;
		});
		todoService.updateLocalStorage();
		return todoService.getAll();
	}
	
	return todoService;
});

todo.controller("TodoController",function($scope,TodoService){
	$scope.todo = TodoService.getAll();
	$scope.newActivity = {};
	$scope.addActivity = function(){
		TodoService.add($scope.newActivity);
		$scope.newActivity = {};
	};
	$scope.removeActivity = function(item){
		$scope.todo = TodoService.removeItem(item);
	}
	$scope.clean = function(){
		$scope.todo = TodoService.clean();
	}
});