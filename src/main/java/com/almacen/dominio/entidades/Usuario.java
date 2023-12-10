package com.almacen.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Usuario {

	private Long id_usuario;
	private String nombre;
	private String apellidos;
	private String password;
	private String email;
	
	private Rol rol;
}
