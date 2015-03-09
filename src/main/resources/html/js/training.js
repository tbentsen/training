var trainingApp = angular.module('trainingApp',['ngResource']);

trainingApp.factory('TrainingSession', function ($resource) {
	return $resource('/service/training/:userId/session', 
			{userId: '@userId'}, {}
	);
});

trainingApp.controller('TrainingController', function ($scope, TrainingSession) {
		$scope.types = [
		    {name: 'Running'},
		    {name: 'Walking'},
		    {name: 'Cycling'}
		]
		$scope.insertTrainingSession = function() {
			TrainingSession.save({userId: 1}, $scope.trainingSession)
		}
})