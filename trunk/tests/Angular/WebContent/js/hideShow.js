var hideShowApp = angular.module("appHideShow",[]);
hideShowApp.controller("HideShowController",function($scope,$http){
	$scope.posts = [];
	$scope.loading = true;
	$scope.newPost = {};
	$http.get("http://jsonplaceholder.typicode.com/posts")
		.success(function(data){
			$scope.posts=data;
			$scope.loading=false;
		})
		.error(function(err){
			$scope.loading=false;
		});
});