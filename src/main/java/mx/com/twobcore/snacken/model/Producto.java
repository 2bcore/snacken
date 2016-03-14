package mx.com.twobcore.snacken.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="producto")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4686059344022639059L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 1l;
	
	@NotNull
    @Size(max = 40)
    @Column(name = "nombre", length = 40, nullable = false)
	private String nombre;
	
	@NotNull
    @Column(name = "costo", precision=10, scale=2, nullable = false)
	private BigDecimal costo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

}
