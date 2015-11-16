function VisController($scope, $http) {
    $scope.svgContainer = d3.select("div").append("svg").attr("width", 800).attr("height", 600);

    $http.get('/lion').
    success(function (data) {
        $scope.lions = data;
        var circles = $scope.svgContainer.selectAll("circle").data(data).enter().append("circle");
        var circleAttributes = circles.attr("cx", function (d) {
            return d.x;
        }).attr("cy", function (d) {
                return d.y;
        }).attr("r", "4")
            .attr("fill", "green");
    });
    $http.get('/region').
    success(function (data) {
        $scope.regions = data;
    });
    $http.get('/pond').
    success(function (data) {
        $scope.ponds = data;
    });


}