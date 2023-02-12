package com.m3.clinica.dtos;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UsuarioDTO extends RepresentationModel<UsuarioDTO> {
	private Long idUsuario;
	private String username;
	private String password;
	private boolean enabled;
}
