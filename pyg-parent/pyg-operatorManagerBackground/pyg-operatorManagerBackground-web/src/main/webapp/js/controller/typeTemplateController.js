 //控制层 
app.controller('typeTemplateController' ,function($scope,$controller   ,typeTemplateService,brandService,specificationService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		typeTemplateService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		typeTemplateService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		typeTemplateService.findOne(id).success(
			function(response){
				$scope.entity= response;		
				
				//转换字符串为json对象（集合）
				$scope.entity.brandIds=  JSON.parse( $scope.entity.brandIds);
				$scope.entity.specIds= JSON.parse($scope.entity.specIds);
				$scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems);
				
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = typeTemplateService.update($scope.entity); //修改
        } else {
            serviceObject = typeTemplateService.add($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //layer弹窗
                    layer.msg(response.message, {
                        time: 1000, icon: 6
                    }, function () {
                        $scope.reloadList();
                    })

                } else {
                    layer.msg(response.message,{icon: 5});
                }
            }
        );
	}
	
	 
	//批量删除 
	$scope.dele=function(){
        if($scope.selectIds.length > 0){
            layer.confirm("确认删除吗？",{
                btn: ['确定','取消'],icon: 3
            },  function(){
                //获取选中的复选框
                typeTemplateService.dele($scope.selectIds).success(
                    function (response) {
                        if (response.success) {
                            layer.msg(response.message,{
                                time: 1000, icon: 6
                            }, function () {
                                $scope.reloadList();//刷新列表
                                $scope.selectIds = [];
                            })
                        }
                    }
                );
            },function () {
                layer.msg("已取消",{icon: 5});
            })
        }else {
            layer.msg("请选择您要删除的信息",{icon: 5});
        }
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	$scope.brandList={data:[]};//品牌列表
    
	//读取品牌列表
	$scope.findBrandList=function(){
		brandService.selectOptionList().success(
			function(response){
				$scope.brandList={data:response};
			}
		);		
	}
	
	$scope.specList={data:[]};//规格列表
	
	//读取规格列表
	$scope.findSpecList=function(){
		specificationService.selectOptionList().success(
				function(response){
					$scope.specList={data:response};
				}
		);		
	}
	
	//增加扩展属性行
	$scope.addTableRow=function(){
		$scope.entity.customAttributeItems.push({});
	}
	//删除扩展属性行
	$scope.deleTableRow=function(index){
		$scope.entity.customAttributeItems.splice( index,1);
	}
	
});	
