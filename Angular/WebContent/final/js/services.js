angular.module("FinalApp")
.factory("PostResource",function($resource){
	return Post = $resource("http://jsonplaceholder.typicode.com/posts/:id",{id:"@id"},{update:{method:"PUT"}});
});