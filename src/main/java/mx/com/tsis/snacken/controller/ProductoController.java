package mx.com.tsis.snacken.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tsis.snacken.model.Producto;
import mx.com.tsis.snacken.util.HeaderUtil;

@RestController
public class ProductoController {

	/**
	 * POST /producto -> crea un nuevo producto.
	 */
	@RequestMapping(value = "/producto/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) throws URISyntaxException {
		Producto resultado = new Producto();
		/** 
		 * proceso para crear el producto
		 */
		
		return ResponseEntity.created(new URI("/producto/" + resultado.getId())).
				headers(HeaderUtil.createEntityCreationAlert("producto", resultado.getId().toString())).body(resultado);
	}
	
	/**
	 * PUT /producto/{id} -> actualiza el empleado
	 */
	
	@RequestMapping(value="/producto/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) throws URISyntaxException{
		Producto regreso = new Producto();
		
		/**
		 * proceso para ctualizar el producto
		 */
		
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("producto", producto.getId().toString()))
				.body(regreso);
		}

	
}
