package mx.com.twobcore.snacken.service;

import java.util.List;

import mx.com.twobcore.snacken.model.Producto;

public interface ProductoService {

	Producto crea(Producto producto);
	Producto actualiza(Producto producto);
	void elimina(Long id);
	Producto consulta(Long id);
	List<Producto> consulta();
	
}
