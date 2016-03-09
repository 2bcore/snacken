package mx.com.tsis.snacken.controller;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import mx.com.tsis.snacken.model.Producto;

public class TestProductoController {

	private ProductoController productoController = new ProductoController();
	
	@Test
	public void testCrearProducto() throws URISyntaxException {
		Producto p = new Producto();
		ResponseEntity<Producto> regreso = productoController.crearProducto(p);
		assertNotNull(regreso);
	}

	@Test
	public void testActualizarProducto() throws URISyntaxException {
		Producto p = new Producto();
		ResponseEntity<Producto> regreso = productoController.actualizarProducto(p);
		assertNotNull(regreso);
	}

}
