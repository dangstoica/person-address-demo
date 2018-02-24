(function() {
	'use strict';

	/* App Module */

	angular.module('personApp', [ 'metawidget' ]).controller(
			'personController',
			function($scope) {
				$scope.person = {
					firstname : '',
					lastname : '',
					streetName : '',
					streetNumber : '',
					cityName : '1',
					relatedWith : null
				};

				$scope.origData = $scope.person;

				$scope.reset = function() {
					$scope.person.firstname = '';
					$scope.person.lastname = '';
					$scope.person.streetName = '';
					$scope.person.streetNumber = '';
					$scope.person.cityName = 1;
					$scope.person.relatedWith = '';
				};
				
				$scope.save = function() {
					if(!$scope.personForm.$valid) {
						alert('Not a valid Form!')
					       return;
					     }

					$("#personForm\\:fName").val(
							$scope.person.firstname);
					$("#personForm\\:lName")
							.val($scope.person.lastname);
					$("#personForm\\:streetName").val(
							$scope.person.streetName);
					$("#personForm\\:streetNumber").val(
							$scope.person.streetNumber);
					$("#personForm\\:cityId").val(
							$('#personCityName').val());
					savePerson();
					$scope.reset();
				};

//				$scope.$watch('person',
//						function() {
//							$("#personForm\\:fName").val(
//									$scope.person.firstname);
//							$("#personForm\\:lName")
//									.val($scope.person.lastname);
//							$("#personForm\\:streetName").val(
//									$scope.person.streetName);
//							$("#personForm\\:streetNumber").val(
//									$scope.person.streetNumber);
//							$("#personForm\\:cityId").val(
//									$('#personCityName').val());
//						}, true);

				$scope.metawidgetConfig = {
					inspector : new metawidget.inspector.JsonSchemaInspector({
						properties : {
							firstname : {
								type : 'string',
								required : true
							},
							lastname : {
								type : 'string',
								required : true
							},
							streetName : {
								type : 'string',
								section : "Address",
								large : false
							},
							streetNumber : {
								type : 'number',
								section : "Address",
								minimum : 0
							},
							cityName : {
								type : 'string',
								section : "Address"
							},
							relatedWith : {
								type : 'string',
								section : "Relationships"
							},
							relationshipType : {
								type : 'string',
								section : "Relationships"
							}

						}
					})
				}

			});
})();