function VisualizationController($scope, $http) {
    $http.get('/lion').
    success(function (data) {
        $scope.lions = data;
    });
    $http.get('/region').
    success(function (data) {
        $scope.regions = data;
    });
    $http.get('/pond').
    success(function (data) {
        $scope.ponds = data;
    });
    $http.get('/ambulance').
    success(function (data) {
        $scope.ambulances = data;
    });
}