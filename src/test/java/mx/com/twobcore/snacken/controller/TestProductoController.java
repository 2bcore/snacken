package mx.com.twobcore.snacken.controller;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import mx.com.twobcore.snacken.config.CORSFilter;
import mx.com.twobcore.snacken.config.SnackenConfigurator;
import mx.com.twobcore.snacken.controller.ProductoController;
import mx.com.twobcore.snacken.model.Producto;
import mx.com.twobcore.snacken.service.ProductoService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=
	{SnackenConfigurator.class,CORSFilter.class}
)
public class TestProductoController {

	@Autowired
	private ProductoController productoController;
	
	@Autowired
	private ProductoService productoService;
	
	@Test
	public void testCrearProducto() throws URISyntaxException {
		Producto p = new Producto();
		p.setCosto(new BigDecimal("100"));
		p.setNombre("nombre1");
		ResponseEntity<Producto> regreso = productoController.crear(p);
		assertNotNull(regreso);
	}

	@Test
	public void testActualizarProducto() throws URISyntaxException {
		List<Producto> productos = productoService.consulta();
		if(productos != null && !productos.isEmpty()){
			Producto p = productos.get(0);
			p.setCosto(p.getCosto().add(BigDecimal.ONE));
			ResponseEntity<Producto> regreso = productoController.actualizar(p);
			assertNotNull(regreso);
		}
	}

}
