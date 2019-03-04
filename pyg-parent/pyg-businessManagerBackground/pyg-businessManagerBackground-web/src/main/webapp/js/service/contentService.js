//服务层
app.service('contentService', function ($http) {

    //分页
    this.search = function (page, rows) {
        return $http.get('/content/search?page=' + page + '&rows=' + rows);
    }
    //查询实体
    this.findOne = function (id) {
        return $http.get('../content/findContentById?id=' + id);
    }
    //增加
    this.add = function (entity) {
        return $http.post('/content/save', entity);
    }
    //修改
    this.update = function (entity) {
        return $http.post('../content/update', entity);
    }
    //删除
    this.dele = function (ids) {
        return $http.get('../content/deleteContentByIds?ids=' + ids);
    }

    this.updateContentStatusOpen = function (ids) {
        return $http.get('../content/updateContentStatus1?ids=' + ids);
    }

    this.updateContentStatusForbidden = function (ids) {
        return $http.get('../content/updateContentStatus0?ids=' + ids);
    }
});
