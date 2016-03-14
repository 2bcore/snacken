'use strict';

App.factory('EmpleadoService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllEmpleados: function() {
					return $http.get('http://${rest-host-name}:${rest-host-port}/${app-name}/empleado/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching Empleados');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createEmpleado: function(empleado){
					return $http.post('http://${rest-host-name}:${rest-host-port}/${app-name}/empleado/', empleado)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating empleado');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateEmpleado: function(empleado, id){
					return $http.put('http://${rest-host-name}:${rest-host-port}/${app-name}/empleado/'+id, empleado)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating empleado');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteEmpleado: function(id){
					return $http.delete('http://${rest-host-name}:${rest-host-port}/${app-name}/empleado/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting empleado');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
