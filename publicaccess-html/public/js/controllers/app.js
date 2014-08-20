function AppCtrl ($scope, $http) {                      

  var server_url = 'http://localhost:7001/publicaccess/rest/nsfpages/topic/'

  $scope.metadata = null;
  $scope.error_message = null;

  $scope.callServer = function(awardId){
    $scope.metadata = null;
    $http.get(server_url + awardId + '.json').
    success(function(data, status, headers, config){
      $scope.metadata = data;
    }).
    error(function(data, status, headers, config) {
      $scope.error_message = status;
    });

  $scope.currentPublication = null;
  $scope.setPublication = function (doi){
    $scope.currentPublication = $scope.metadata.pubMetadataMap[doi];
    console.log($scope.currentPublication);
  };

  };// end of function
}