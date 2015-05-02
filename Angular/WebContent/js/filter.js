var fApp = angular.module("appFiltro",[]);
fApp.filter("removeHtml",function(){
	return function(textoAFormatear){
		return String(textoAFormatear).replace(/<[^>]+>/gm,'');
	};
});
fApp.controller("FiltroController",function($scope){
	$scope.miHtml = "<p><b>Hola mundo</b></p>";
	$scope.objetoParaJson = {};
	$scope.objetoParaJson.id = 50;
	$scope.objetoParaJson.descrpcion = "la descripcion";
	$scope.precio = 2;
	$scope.nombre = "Nacho";
	setTimeout(function(){
		//$scope.nombre = "Pepe";
		//$scope.$digest(); //el cambio de nombre aca no se refleja en pantalla, $scope.$digest() fuerza el update de la pantalla
		//$scope.$apply(); //hace lo mismo que antes
		//la mejor forma. 
		$scope.$apply(function(){
			$scope.nombre = "Pepe";
		});
	},2000);
	document.querySelector("#boton").addEventListener("click", function(){ //ejemplo de como se agrega un evento mas lindo :P
		$scope.$apply(function(){ //como esto no esta hecho con ng-click, si no uso el $apply no se actualiza la vista.
			$scope.nombre = "Isabel";
		});
	});
});