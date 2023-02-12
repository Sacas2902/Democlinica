package com.m3.clinica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.m3.clinica.modelo.Usuario;

public interface IUsuarioRepository  extends JpaRepository<Usuario,Integer> {
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsernameQuery(String username);
	
	@Query("from Usuario m where LOWER(m.username) like %:filtro%")
	List<Usuario> buscarByAny(@Param("filtro") String filtro );
}
