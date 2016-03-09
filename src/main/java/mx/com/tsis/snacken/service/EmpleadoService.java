package mx.com.tsis.snacken.service;

import java.util.List;

import mx.com.tsis.snacken.model.Empleado;

public interface EmpleadoService {

	Empleado save(Empleado empleado);

	List<Empleado> findAll();

	Empleado findOne(Long id);

	void delete(Long id);

}
