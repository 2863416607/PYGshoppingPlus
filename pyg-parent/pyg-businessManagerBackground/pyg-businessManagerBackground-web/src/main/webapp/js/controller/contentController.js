//控制层
app.controller('contentController', function ($scope, $controller, contentService, uploadService, contentCategoryService) {

    $controller('baseController', {$scope: $scope});//继承

    //分页
    $scope.search = function (page, rows) {
        contentService.search(page, rows).success(
            function (response) {
                $scope.entityList = response.list;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne = function (id) {
        contentService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }

    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = contentService.update($scope.entity); //修改
        } else {
            serviceObject = contentService.add($scope.entity);//增加
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
                contentService.dele($scope.selectIds).success(
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


    //上传图片
    $scope.uploadFile = function () {
        uploadService.uploadFile().success(
            function (response) {
                if (response.flag==1) {
                    $scope.entity.pic = response.message;
                } else {
                    alert(response.message);
                }
            }
        ).error(
            function () {
                alert("上传出错");
            }
        );
    }

    //查询广告分类 列表
    $scope.findContentCategoryList = function () {
        contentCategoryService.findAll().success(
            function (response) {
                $scope.contentCategoryList = response;
            }
        );
    }

    $scope.updateContentStatusOpen = function () {
        contentService.updateContentStatusOpen($scope.selectIds).success(
            function (response) {
                alert(response.message)
                $scope.reloadList();
            }
        );
    }

    $scope.updateContentStatusForbidden = function () {
        contentService.updateContentStatusForbidden($scope.selectIds).success(
            function (response) {
                alert(response.message)
                $scope.reloadList();
            }
        );
    }

    $scope.status=['无效','有效'];
});	
