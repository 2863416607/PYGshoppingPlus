//控制层
app.controller('brandController', function ($scope, $controller, brandService) {

    $controller('baseController', {$scope: $scope});//继承


    //分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }

    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = brandService.update($scope.entity); //修改
        } else {
            serviceObject = brandService.add($scope.entity);//增加
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
                    layer.msg(response.message,{icon:5});
                }
            }
        );
    }


    //批量删除
    $scope.dele = function () {
        if($scope.selectIds.length > 0){
            layer.confirm("确认删除吗？",{
                btn: ['确定','取消'],icon: 3
            },  function(){
                //获取选中的复选框
                brandService.dele($scope.selectIds).success(
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

    $scope.searchEntity = {};//定义搜索对象

    //搜索
    $scope.search = function (page, rows) {
        brandService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

});	
