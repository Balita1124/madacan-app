'use strict';

angular.module('applicantList', ['ui.router'])
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('applicants', {
                parent: 'app',
                url: '/applicants',
                template: '<applicant-list></applicant-list>'
            })
    }]);
