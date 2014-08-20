function AppCtrl ($scope, $http) {
  $scope.airports = {
    "PDX": {
      "code": "PDX",
      "name": "Portland International Airport",
      "city": "Portland",
      "destinations": [
        "LAX",
        "SFO"
      ]
    },
    "STL": {
      "code": "STL",
      "name": "Lambert-St. Louis International Airport",
      "city": "St. Louis",
      "destinations": [
        "LAX",
        "MKE"
      ]
    },
    "MCI": {
      "code": "MCI",
      "name": "Kansas City International Airport",
      "city": "Kansas City",
      "destinations": [
        "LAX",
        "DFW"
      ]
    }
  };

  $scope.publications = {  "test1": {"language":"English",
                          "type":"Journal Article",
                          "date":null,
                          "format":"Medium: X",
                          "description":"Not Available",
                          "subject":null,
                          "title":"Entanglement's Benefit Survives an Entanglement-Breaking Channel",
                          "identifier":"OSTI ID: 502",
                          "doi":"1321657987",
                          "creator":"Zhang, Zheshen (ORCID:0000000000000005); Tengner, Maria; Zhong, Tian; Wong, Franco N. C.; Shapiro, Jeffrey H.",
                          "publisher":"American Physical Society",
                          "publisherAvailability":false,
                          "publisherResearch":"None",
                          "publisherSponsor":"None",
                          "publisherCountry":"US",
                          "typeQualifier":null,
                          "relation":"Journal Name: Physical Review Letters Journal Volume: 111 Journal Issue: 1",
                          "coverage":null,"identifierReport":"None",
                          "identifierNSFAwardId":"1234567",
                          "identifierOther":"Journal ID: ISSN 0031-9007",
                          "rights":false,
                          "dateEntry":null,
                          "ostiId":"502",
                          "peerReviewFlag":true,
                          "nsfFunded":true
                          },
                          "test2": {"language":"English",
                          "type":"Journal Article",
                          "date":null,
                          "format":"Medium: X",
                          "description":"Not Available",
                          "subject":null,
                          "title":"Entanglement's Benefit Survives an Entanglement-Breaking Channel",
                          "identifier":"OSTI ID: 502",
                          "doi":"1321657987",
                          "creator":"Zhang, Zheshen (ORCID:0000000000000005); Tengner, Maria; Zhong, Tian; Wong, Franco N. C.; Shapiro, Jeffrey H.",
                          "publisher":"American Physical Society",
                          "publisherAvailability":false,
                          "publisherResearch":"None",
                          "publisherSponsor":"None",
                          "publisherCountry":"US",
                          "typeQualifier":null,
                          "relation":"Journal Name: Physical Review Letters Journal Volume: 111 Journal Issue: 1",
                          "coverage":null,"identifierReport":"None",
                          "identifierNSFAwardId":"1234567",
                          "identifierOther":"Journal ID: ISSN 0031-9007",
                          "rights":false,
                          "dateEntry":null,
                          "ostiId":"502",
                          "peerReviewFlag":true,
                          "nsfFunded":true
                          }
                        };

                        
  $scope.sidebarURL = 'partials/airport.html';
  $scope.currentAirport = null;

  $scope.setAirport = function (code) {
    $scope.currentAirport = $scope.airports[code];
  };

  $scope.metadata = null;
  $scope.callServer = function(awardId){
    //alert("calling server!");
    $http.get('http://localhost:7001/publicaccess/rest/nsfpages/topic/123.json').
    success(function(data, status, headers, config){
      $scope.metadata = data;
    }).
    error(function(data, status, headers, config) {
      alert(status);
    });

  $scope.currentPublication = null;
  $scope.setPublication = function (doi){
    $scope.currentPublication = $scope.metadata.pubMetadataMap[doi];
    console.log($scope.currentPublication);
  };

  };// end of function
}