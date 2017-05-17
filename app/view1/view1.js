'use strict';

angular.module('myApp.view1', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view1', {
            templateUrl: 'view1/view1.html',
            controller: 'View1Ctrl'
        });
    }])

    .directive("initMap", function ($window) {
        return {
            restrict: "E",
            template: '<div style="height: 400px;">XXX</div>',
            link: function (scope, elem, attrs) {
                var jElem = elem.find('div')[0];
                console.log(jElem);
                scope[attrs.map] = new google.maps.Map(jElem, {
                    center: {lat: 55.6761, lng: 12.5683},
                    zoom: 8
                });
                console.log(jElem);
            }
        };
    })

    .controller('myCtrl', function($scope) {
        $scope.cityName = "cityName";
        $scope.bookTitle = "bookTitle";
        $scope.authorName = "authorName";
    })

    //Change the controllers to match correct the api call
    .controller('Query1', ['$scope', '$http', function ($scope, $http) {
        $scope.searchByCityName = function(){
            var cityName = $scope.cityName;// insert this into the restCAll
            $http.get('PATHTOSERVER')
                .then(function (response) {
                    $scope.books = response.data.books;
            });
        }
    }])

    .controller('Query2', ['$scope', '$http', function ($scope, $http) {
        $http.get('http://rest-service.guides.spring.io/greeting').then(function (response) {
            $scope.greeting = response.data;
        });
    }])

    .controller('Query3', ['$scope', '$http', function ($scope, $http) {
        $http.get('http://rest-service.guides.spring.io/greeting').then(function (response) {
            $scope.greeting = response.data;
        });
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