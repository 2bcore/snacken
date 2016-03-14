package mx.com.twobcore.snacken.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.twobcore.snacken.model.Producto;
import mx.com.twobcore.snacken.service.ProductoService;
import mx.com.twobcore.snacken.util.HeaderUtil;

@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;

	/**
	 * POST /producto -> crea un nuevo producto.
	 */
	@RequestMapping(value = "/producto/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> crear(@RequestBody Producto producto) throws URISyntaxException {
		Producto resultado = productoService.crea(producto);
		return ResponseEntity.created(new URI("/producto/" + resultado.getId()))
				.headers(HeaderUtil.createEntityCreationAlert("producto", resultado.getId().toString()))
				.body(resultado);
	}

	/**
	 * PUT /producto/{id} -> actualiza el empleado
	 */

	@RequestMapping(value = "/producto/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> actualizar(@RequestBody Producto producto) throws URISyntaxException {
		Producto regreso = productoService.actualiza(producto);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("producto", producto.getId().toString()))
				.body(regreso);
	}
	/**
	 * DELETE /producto/{id} > elimina prodcuto
	 */
	
	@RequestMapping(value="/producto/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> eliminar(@PathVariable Long id){
		productoService.elimina(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("prodcuto", id.toString())).build();
	}
	
	/**
	 * GET /prodcuto -> get all the empleados.
	 */
	@RequestMapping(value = "/producto/", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getAllProductos() {
		List<Producto> productos = productoService.consulta();
		if(productos.isEmpty()){
			new ResponseEntity<List<Producto>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);

	}

	/**
	 * GET /producto/{id} -> get the "id" producto.
	 */
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> getProducto(@PathVariable Long id) {
		Producto producto = productoService.consulta(id);
		return Optional.ofNullable(producto).map(result -> new ResponseEntity<>(producto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}


}
