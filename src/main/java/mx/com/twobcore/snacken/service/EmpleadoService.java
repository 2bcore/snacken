package mx.com.twobcore.snacken.service;

import java.util.List;

import mx.com.twobcore.snacken.model.Empleado;

public interface EmpleadoService {

	Empleado save(Empleado empleado);

	List<Empleado> findAll();

	Empleado findOne(Long id);

	void delete(Long id);

}
