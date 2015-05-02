var app = angular.module("app",[]);
app.controller("HolaController", function($scope,$http){
	$scope.nombre = "Nachoooooooooooo";
	$scope.nuevoComentario= {};
	$scope.newPost = {};
	$scope.addPost = function(){
		$http.post("http://jsonplaceholder.typicode.com/posts",{
			title: $scope.newPost.title,
			body: $scope.newPost.body,
			userId:1
		}).success(function(data,status,headers,config){
			$scope.posts.push($scope.newPost);
			$scope.newPost = {};
		}).error(function(data,status,headers,config){
			console.log(error);
		});
	};
	$scope.comentarios = [{
	    	 comentario:"Comentario 1",
	    	 usuario:"Nacho"
	     },{
	    	 comentario:"Comentario 2",
	    	 usuario:"Pepe"
	     }
	];
	$scope.agregarComentario=function(){
		$scope.comentarios.push($scope.nuevoComentario);
		$scope.nuevoComentario={};
	};
	$http.get("http://jsonplaceholder.typicode.com/posts")
		.success(function(data){
			$scope.posts=data;
		})
		.error(function(err){
			
		});
});