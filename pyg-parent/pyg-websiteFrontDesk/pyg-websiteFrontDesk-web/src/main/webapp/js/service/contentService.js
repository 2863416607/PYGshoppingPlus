app.service("contentService", function ($http) {

    this.findByCategoryId = function (categoryId) {
        return $http.get("../index/findByCategoryId?categoryId=" + categoryId);
    }

});