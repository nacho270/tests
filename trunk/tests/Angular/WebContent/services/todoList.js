var todo = angular.module("todo",["LocalStorageModule"]);
todo.service('TodoService',function(localStorageService){
	this.key = "angularTodoList";
	if(localStorageService.get(this.key) ){
		this.activities = localStorageService.get(this.key);
	}else{
		this.activities = [];
	}

	this.add = function(newActiv){
		this.activities.push(newActiv);
		this.updateLocalStorage();
	}
	
	this.updateLocalStorage = function(){
		localStorageService.set(this.key,this.activities);
	}
	
	this.clean = function(){
		this.activities = [];
		this.updateLocalStorage();
		return this.getAll();
	}
	
	this.getAll = function(){
		return this.activities;
	}
	
	this.removeItem = function(item){
		this.activities = this.activities.filter(function(activity){
			return activity !== item;
		});
		this.updateLocalStorage();
		return this.getAll();
	}
	
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