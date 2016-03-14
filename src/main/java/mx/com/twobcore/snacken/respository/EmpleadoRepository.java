package mx.com.twobcore.snacken.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.twobcore.snacken.model.Empleado;

/**
 * Spring Data JPA repository for the Empleado entity.
 */
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

}
