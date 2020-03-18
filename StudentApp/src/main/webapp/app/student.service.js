angular.module('crudApp').factory('Student',Student);

Student.$inject = [ '$resource' ];

function Student($resource) {
	var resourceUrl = 'api/student/:id';
	
	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}
