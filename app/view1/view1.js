'use strict';

angular.module('myApp.view1', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view1', {
            templateUrl: 'view1/view1.html',
            controller: 'View1Ctrl'
        });
    }])

    .service('Map', function($q) {
    this.init = function() {
        //  navigator.geolocation.getCurrentPosition(function(position) {
        var MapOptions = {
            center: new google.maps.LatLng(55.676098, 12.568337),
            zoom: 3,
            disableDefaultUI: true,
            draggable: true,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
        };
        this.map = new google.maps.Map(document.getElementById("map"), MapOptions);
        // });
    }
})
    .service("MapService", function(Map) {
        return {
            addtomap: function(lat, lng) {
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(lat, lng),
                    map: Map.map
                });
            }
        }
    })

    .controller('MapCtrl', function($scope, Map) {
        $scope.fetchdata = {};
        //var Fetchdata = $resource('http://localhost:8080/fetchnote');
        //Fetchdata.query(function(results) {
        $scope.fetchdata = [{latitude : 55.676098, longitude : 12.568337}];

        //})



        function addtomap(lat, lng, icon) {
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(lat, lng),
                map: Map.map
            });
        }

        Map.init();
        angular.forEach($scope.fetchdata, function(value, index) {
            //alert(value);
            var lat = value.latitude;
            var lng = value.longitude;
            addtomap(lat, lng)
        });
    })

    //Change the controllers to match correct the api call
    .controller('Query1', ['$scope', '$http', function ($scope, $http) {
        $scope.searchByCityName = function(){
            var cityName = $scope.cityName;// insert this into the rest CAll
            $http.get('http://localhost:8080/1?cityName=' + cityName + '')
                .then(function (response) {
                    $scope.books = response.data;
            });
        }
    }])

    .controller('Query2', ['$scope', '$http', 'MapService', function ($scope, $http, MapService) {
        $scope.searchByBookTitle = function(){
            var bookTitle = $scope.bookTitle;// insert this into the rest CAll
            $http.get('http://localhost:8080/2?bookTitle=' + bookTitle + '')
                .then(function (response) {
                    $scope.bookTitles = response.data;
                    //console.log($scope.bookTitles);
                    var arrayLength = $scope.bookTitles.length; 
                    for (var i = 0; i < arrayLength; i++) { 
                        var lat = $scope.bookTitles[i].latitude;
                        var lng = $scope.bookTitles[i].longitude;
                        MapService.addtomap(lat, lng);
                    }
                });
        };
    }])

    .controller('Query3', ['$scope', '$http', 'MapService', function ($scope, $http, MapService) {
        $scope.searchByAuthorName = function(){
        var authorName = $scope.authorName;
        $http.get('http://localhost:8080/3?author=' + authorName + '')
            .then(function (response) {
            $scope.books = response.data[0].cities;
            console.log($scope.books[0].cities);
                var arrayLength = $scope.books.length;
                for (var i = 0; i < arrayLength; i++) {
                    var lat = $scope.books[i].latitude;
                    var lng = $scope.books[i].longitude;
                    MapService.addtomap(lat, lng);
                }
        });
        }
    }])

    .controller('Query4', ['$scope', '$http', function ($scope, $http) {
        $http.get('http://rest-service.guides.spring.io/greeting').then(function (response) {
            $scope.greeting = response.data;
        });
    }])

    .controller('View1Ctrl', ['$scope', '$http', function ($scope, $http) {
        $http.get('http://rest-service.guides.spring.io/greeting').then(function (response) {
            $scope.greeting = response.data;
        });
    }]);