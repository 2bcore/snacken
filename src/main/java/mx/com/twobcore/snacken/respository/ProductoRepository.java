package mx.com.twobcore.snacken.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.twobcore.snacken.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{

}
