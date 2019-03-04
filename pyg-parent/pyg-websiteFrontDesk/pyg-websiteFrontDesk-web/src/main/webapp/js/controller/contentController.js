app.controller("contentController",function($scope,contentService){
	$scope.contentList = [];
	// 根据分类ID查询广告的方法:
	$scope.findByCategoryId = function(categoryId){
		contentService.findByCategoryId(categoryId).success(function(response){
			$scope.contentList = response;
		});
	}


	//搜索  （传递参数）
	$scope.search=function(){
		location.href="http://http://localhost:8083/index/search?keywords="+$scope.keywords;
	}
	
});