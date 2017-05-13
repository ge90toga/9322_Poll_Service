// ROUTES
foundITApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'pages/login/login.html',
            controller: 'loginController'
        })

        .when('/:pollID', {
            templateUrl: 'pages/login/login.html',
            controller: 'loginController'
        })
});