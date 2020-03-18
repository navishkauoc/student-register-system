angular.module("crudApp").controller("GeneralController", GeneralController);

GeneralController.inject = [ '$scope', 'Student' ];

function GeneralController($scope, Student) {
	
	$scope.students = Student.query();
	
	$scope.student = {};
	
	$scope.buttonText = "Submit";
	
	$scope.saveStudent = function() {
		if($scope.student.id !== undefined) {
			Student.update($scope.student, function() {
				$scope.students = Student.query();
				$scope.student = {};
				$scope.buttonText = "Submit";
			});
		} else {
			Student.save($scope.student, function() {
				$scope.students = Student.query();
				$scope.student = {};
			});
		}
	}
	
	$scope.updateStudentInit = function(student){
		$scope.buttonText = "Update";
		$scope.student = student;
	}
	
	$scope.deleteStudent = function(student){
		student.delete({id:student.id},function(){
			$scope.students=Students.query();
		});
	}
	
}