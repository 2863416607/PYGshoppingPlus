 //控制层 
app.controller('itemCatController' ,function($scope,$controller   ,itemCatService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		itemCatService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		itemCatService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		itemCatService.findOne(id).success(
			function(response){
				$scope.entity= response;					
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
                itemCatService.dele($scope.selectIds).success(
                    function (response) {
                        if (response.success) {
                            layer.msg(response.message,{
                                time: 1000, icon: 6
                            }, function () {
                                $scope.findByParentId($scope.parentId);//重新加载
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
		itemCatService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
	//根据上级分类ID查询列表
	$scope.findByParentId=function(parentId){
		itemCatService.findByParentId(parentId).success(
			function(response){
				$scope.list=response;				
			}
		);		
	}
	
	$scope.grade=1;//当前级别
	//设置级别 
	$scope.setGrade=function(value){
		$scope.grade=value;
	}
	
	
	$scope.selectList=function(p_entity){
		
		if($scope.grade==1){
			$scope.entity_1=null;
			$scope.entity_2=null;
		}
		if($scope.grade==2){
			
			$scope.entity_1=p_entity;
			$scope.entity_2=null;
		}
		if($scope.grade==3){
			$scope.entity_2=p_entity;
		}
		
		$scope.findByParentId(p_entity.id);
		
	}

    $scope.parentId=0;//上级ID

    //根据上级ID显示下级列表
    $scope.findByParentId=function(parentId){
        $scope.parentId=parentId;//记住上级ID
        itemCatService.findByParentId(parentId).success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //新增保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.entity.id!=null){//如果有ID
            serviceObject=itemCatService.update( $scope.entity ); //修改
        }else{
            $scope.entity.parentId=$scope.parentId;//赋予上级ID
            serviceObject=itemCatService.add( $scope.entity );//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //layer弹窗
                    layer.msg(response.message, {
                        time: 1000, icon: 6
                    }, function () {
                        $scope.findByParentId($scope.parentId);//重新加载
                    })

                } else {
                    layer.msg(response.message,{icon : 5});
                }
            }
        );
    }
});	
