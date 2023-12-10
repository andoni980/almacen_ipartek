package com.almacen.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Producto {
	
	private Long idProducto;
	private String nombre;
	private Long idCategoria;
	private String codigoBarras;
	private BigDecimal precioVenta;
	private Integer cantidadStock;
	private Boolean estado;
	private LocalDate fechaCaducidad;
}
