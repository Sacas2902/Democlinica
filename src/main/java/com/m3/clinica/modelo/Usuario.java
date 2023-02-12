package com.m3.clinica.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(unique=true,length=20)
	private String username;
	@Column(length=80)
	private String password;
	private String email;
	private boolean enabled;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name="id_usuario"),
	inverseJoinColumns = @JoinColumn(name="id_rol"),uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario","id_rol"})})
	private List<Rol> roles;	
	
}
