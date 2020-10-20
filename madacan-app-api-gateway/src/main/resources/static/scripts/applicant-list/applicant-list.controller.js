'use strict';

angular.module('applicantList')
    .controller('ApplicantListController', ['$http', function ($http) {
        var self = this;

        $http.get('api/applicant/applicants').then(function (resp) {
            console.log("Get List des applicants");
            self.applicants = resp.data;
        });
    }]);
