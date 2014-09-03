function AppCtrl ($scope, $http) {                      

  var host = 'http://i-app-srvc01.ashburn.nsf.gov:7005'
  var server_url = host + '/publicaccess/rest/nsfpages/topic/'

  $scope.metadata = null;
  $scope.error_message = null;

  $scope.callServer = function(awardId){
    $scope.metadata = null;
    $scope.currentPublication = null;
    $http.get(server_url + awardId + '.json').
    success(function(data, status, headers, config){
      $scope.metadata = data;
    }).
    error(function(data, status, headers, config) {
      $scope.error_message = status;
    });
  };// end of function

    $scope.callServerBatch = function(dateTime){

    var dateTimeParam = dateTime.replace(":", "_");
    $scope.metadata = null;
    $scope.currentPublication = null;
    var batch_url = server_url + 'batch.json?batchCallLastTimestamp=' + dateTimeParam;
    console.log(batch_url);
    $http.get(batch_url).
    success(function(data, status, headers, config){
      $scope.metadata = data;
    }).
    error(function(data, status, headers, config) {
      $scope.error_message = status;
    });
  }; //end of function

  $scope.currentPublication = null;
  $scope.setPublication = function (doi){
    $scope.currentPublication = $scope.metadata.pubMetadataMap[doi];
    console.log($scope.currentPublication);

  };// end of function
}