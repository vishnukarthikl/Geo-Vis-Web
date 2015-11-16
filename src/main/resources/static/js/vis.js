function VisController($scope, $http) {
    $scope.svgContainer = d3.select("div").append("svg").attr("width", 800).attr("height", 600);

    $http.get('/lion').
    success(function (data) {
        $scope.lions = data;
        var circles = $scope.svgContainer.selectAll("lion").data(data).enter().append("circle");
        var text = $scope.svgContainer.selectAll("lion-text").data(data).enter().append("text");
        var circleAttributes = circles.attr("cx", function (d) {
            return d.x;
        }).attr("cy", function (d) {
            return d.y;
        }).attr("r", "4")
            .attr("fill", "green");
        var textLabels = text
            .attr("x", function (d) {
                return d.x-5;
            })
            .attr("y", function (d) {
                return d.y + 15;
            })
            .text(function (d) {
                return d.name
            })
            .attr("font-size", "10px")
    });
    $http.get('/region').
    success(function (data) {
        $scope.regions = data;
        var regions = $scope.svgContainer.selectAll("region").data(data).enter().append("polygon");
        var text = $scope.svgContainer.selectAll("region-text").data(data).enter().append("text");
        regions.attr("points", function (d) {
            return d.points.map(function (d) {
                return [d.x, d.y].join(",");
            }).join(" ");
        }).attr("stroke", "black").attr("stroke-width", "2px").style("fill", "none");
        var textLabels = text
            .attr("x", function (d) {
                return d.points[0].x + 10;
            })
            .attr("y", function (d) {
                return d.points[0].y + 30;
            })
            .text(function (d) {
                return d.name
            })
            .attr("font-size", "10px");
    });
    $http.get('/pond').
    success(function (data) {
        $scope.ponds = data;
        var circles = $scope.svgContainer.selectAll("pond").data(data).enter().append("circle");
        var text = $scope.svgContainer.selectAll("pond-text").data(data).enter().append("text");
        var circleAttributes = circles.attr("cx", function (d) {
            return d.centerX;
        }).attr("cy", function (d) {
            return d.centerY;
        }).attr("r", function (d) {
                return d.radius;
            })
            .attr("fill", "lightblue")
            .attr("stroke", "black")
            .attr("stroke-width", "1px");
        var textLabels = text
            .attr("x", function (d) {
                return d.centerX-5;
            })
            .attr("y", function (d) {
                return d.centerY+3;
            })
            .text(function (d) {
                return d.name
            })
            .attr("font-size", "10px")
    });


}