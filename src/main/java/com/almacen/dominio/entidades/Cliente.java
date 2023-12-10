package com.almacen.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Cliente {

	private Long idCliente;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String correoElectronico;
	private String nif;
//	private List<Salida> salidas;
//	private ??????¿ ficheros;
}
