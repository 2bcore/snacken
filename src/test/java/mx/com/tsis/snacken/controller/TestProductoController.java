package mx.com.tsis.snacken.controller;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.net.URISyntaxException;

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
		Producto p = productoService.consulta(1l);
		p.setCosto(new BigDecimal("300"));
		ResponseEntity<Producto> regreso = productoController.actualizar(p);
		assertNotNull(regreso);
	}

}
