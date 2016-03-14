package mx.com.twobcore.snacken.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.twobcore.snacken.model.Producto;
import mx.com.twobcore.snacken.respository.ProductoRepository;
import mx.com.twobcore.snacken.service.ProductoService;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public Producto crea(Producto producto) {
		
		return productoRepository.saveAndFlush(producto);
	}

	@Override
	public Producto actualiza(Producto producto) {
		if(producto.getId() == null){
			return crea(producto);
		}		
		return productoRepository.saveAndFlush(producto);
	}

	@Override
	public void elimina(Long id) {
		productoRepository.delete(id);
		
	}

	@Override
	public Producto consulta(Long id) {
		return productoRepository.findOne(id);
	}

	@Override
	public List<Producto> consulta() {
		return productoRepository.findAll();
	}

}
