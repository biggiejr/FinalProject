(function () {
    'use strict';

    angular.module('myApp.view1.query2', ['ngRoute'])
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view1', {
                templateUrl: 'view1/view1.html',
                controller: 'View1Ctrl'
            });
        }])
        .controller('query2Ctrl', function ($scope, $http) {

            $scope.searchCity = function(){
                /*$http.get('http://localhost:8080/1?name={cityName}')
                    .then(function (response) {
                        console.log(response.data.books);
                        $scope.books = response.data.books;
                    });*/
                console.log('you fat!!');
            };

            /*var cityName = $routeParams.cityName;// insert this into the rest CAll
            $http.get('http://localhost:8080/1?name={cityName}')
                .then(function (response) {
                    console.log(response.data.books);
                    $scope.books = response.data.books;
                });*/

        });
}());