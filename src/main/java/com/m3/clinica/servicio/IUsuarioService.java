package com.m3.clinica.servicio;

import java.util.List;

import com.m3.clinica.modelo.Usuario;

public interface IUsuarioService extends ICRUD<Usuario> {
	List<Usuario> buscarByAny(String filtro);

	Usuario cambiarPassword(Usuario usuario);
}
