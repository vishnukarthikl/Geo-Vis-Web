function VisController($scope, $http) {
    $scope.svgContainer = d3.select("div").append("svg").attr("width", 800).attr("height", 600);

    $http.get('/lion').
    success(function (data) {
        $scope.lions = data;
    });

    $http.get('/pond').
    success(function (data) {
        $scope.ponds = data;
        showPonds();
    });

    function getItemsToHighlight(regionName) {
        return ["L1", "L2", "P2"];
    }

    function showItemsIn(regionName) {
        var itemsToHighlight = getItemsToHighlight(regionName);
        itemsToHighlight.forEach(function (item) {
            d3.selectAll("#" + item).data($scope.lions).attr("fill", "red");
        })

    }

    $http.get('/region').
    success(function (data) {
        $scope.regions = data;
        showRegions();
        showLions();
        showPonds();
    });


    function showLions() {
        var circles = $scope.svgContainer.selectAll("lion").data($scope.lions).enter().append("circle");
        var text = $scope.svgContainer.selectAll("lion-text").data($scope.lions).enter().append("text");
        var circleAttributes = circles.attr("cx", function (d) {
            return d.x;
        }).attr("cy", function (d) {
            return d.y;
        }).attr("r", "4")
            .attr("id", function (d) {
                return d.name
            })
            .attr("fill", "green");
        var textLabels = texkt
            .attr("x", function (d) {
                return d.x - 5;
            })
            .attr("y", function (d) {
                return d.y + 15;
            })
            .text(function (d) {
                return d.name
            })
            .attr("font-size", "10px")
    }

    function showRegions() {
        var regions = $scope.svgContainer.selectAll("region").data($scope.regions).enter().append("polygon");
        var text = $scope.svgContainer.selectAll("region-text").data($scope.regions).enter().append("text");
        regions.on("click", function (d) {
            showItemsIn(d.name);
        }).attr("fill", "white")
            .attr("points", function (d) {
                return d.points.map(function (d) {
                    return [d.x, d.y].join(",");
                }).join(" ");
            })
            .attr("id", function (d) {
                return d.name
            })
            .attr("stroke", "black").attr("stroke-width", "2px");
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
    }

    function showPonds() {
        var circles = $scope.svgContainer.selectAll("pond").data($scope.ponds).enter().append("circle");
        var text = $scope.svgContainer.selectAll("pond-text").data($scope.ponds).enter().append("text");
        var circleAttributes = circles.attr("cx", function (d) {
            return d.centerX;
        }).attr("cy", function (d) {
            return d.centerY;
        }).attr("r", function (d) {
                return d.radius;
            })
            .attr("fill", "lightblue")
            .attr("stroke", "black")
            .attr("id", function (d) {
                return d.name
            })
            .attr("stroke-width", "1px");
        var textLabels = text
            .attr("x", function (d) {
                return d.centerX - 5;
            })
            .attr("y", function (d) {
                return d.centerY + 3;
            })
            .text(function (d) {
                return d.name
            })
            .attr("font-size", "10px")
    }


}