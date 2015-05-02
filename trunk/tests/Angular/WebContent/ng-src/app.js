angular.module("CustomDirective",[])
.directive("backImg",function(){ //el camelCase agrega un -... backImg => back-img
	return function(scope, element, attrs){
		attrs.$observe('backImg',function(value){
			element.css({
				"background":"url("+value+")",
				"background-position": "center", 
				"background-size":"cover"
			});
		});
	}
})
.controller("AppCtrl",function($scope,$http){
	$http.get("https://api.github.com/users/codigofacilito/repos")
	.success(function(data){
		$scope.repos = data;
	})
	.error(function(err){
		console.log(err);
	});
});