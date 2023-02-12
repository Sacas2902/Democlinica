package com.m3.clinica.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m3.clinica.modelo.Usuario;
import com.m3.clinica.repositorio.IUsuarioRepository;
import com.m3.clinica.servicio.IUsuarioService;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService {

	final private IUsuarioRepository usuarioRepository;
	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Autowired
	public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsernameQuery(username);
		if (usuario == null) {
			logger.error("Error en el login: no existe el usuario en " + username + " el sistema");
			throw new UsernameNotFoundException(
					"Error en el login: no existe el usuario en " + username + " el sistema");
		}

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombreRol()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority())).collect(Collectors.toList());
		return new User(username, usuario.getPassword(), usuario.isEnabled(), true, true, true, authorities);
	}

	@Override
	public Usuario registrar(Usuario item) {
		// TODO Auto-generated method stub
		item.setPassword(this.codificarPassword(item.getPassword()));
		return this.usuarioRepository.save(item);
	}

	@Override
	public Usuario modificar(Usuario item) {
		// TODO Auto-generated method stub
		//item.setPassword(this.codificarPassword(item.getPassword()));
		return this.usuarioRepository.save(item);
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> listUsuarios = this.usuarioRepository.findAll();
		return listUsuarios;
	}

	@Override
	public Usuario leerPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean eliminar(Usuario obj) {
		// TODO Auto-generated method stub
		try {
			this.usuarioRepository.delete(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Usuario> buscarByAny(String filtro) {
		return this.usuarioRepository.buscarByAny(filtro);
	}

	private String codificarPassword(String password) {
		String passwordBcrypt = passEncoder.encode(password);
		return passwordBcrypt;
	}
	
	public Usuario cambiarPassword(Usuario item) {
		// TODO Auto-generated method stub
		item.setPassword(this.codificarPassword(item.getPassword()));
		return this.usuarioRepository.save(item);
	}

}
