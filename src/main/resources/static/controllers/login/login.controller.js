foundITApp.controller('loginController', function ($scope, $location, toaster, $timeout, $routeParams, $http) {
    $scope.init = function () {
        console.log('pollid', $routeParams.pollID);
        $scope.data = {
            baseUrl: 'http://192.168.99.100:8200/',
            poll: {},
            voted: false
        };
        $scope.loadPoll($routeParams.pollID);
    };

    $scope.loadPoll = function (pollID) {
        $http({
            method: 'GET',
            url: $scope.data.baseUrl + 'api/poll/' + pollID
        }).then(function (pollRes) {
            console.log('poll', pollRes.data);
            $scope.data.poll = pollRes.data;
        }, function (err) {
            console.log('got error', err);
        })
    };

    $scope.votefor = function (idx) {
        console.log('vote for', $scope.data.poll.votes[idx]);
        var fd = new FormData();
        fd.append('identity', $scope.data.poll.identity);
        fd.append('voteName', $scope.data.poll.votes[idx].name);
        $http.post($scope.data.baseUrl + 'api/vote', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(function () {
            toaster.pop('success', 'successfully voted', '');
            $scope.data.voted = true;
            $scope.loadPoll($routeParams.pollID);
        }, function (error) {
            toaster.pop('error', 'vote error!', '');
            console.log(error);
        })
    };

    $scope.test = function () {
        console.log('vote ');
    };

    console.log('loginController::init');
    $scope.init();
});
