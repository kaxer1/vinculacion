package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.NumericBooleanConverter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@Comment("Tabla que almacena detalle de informacion de un usuario")
@Entity
@Table(name = "usuariodetalle")
public class Usuariodetalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Comment("Codigo de usuario.")
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;

	@ManyToOne()
	@Comment("Codigo de personas")
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JoinColumn(name = "idpersona")
	private Personadetalle idpersona;

	@Comment("Codigo de usuario de ingreso.")
	@Column(name = "idusuarioing", length = 20)
	private String idusuarioing;

	@Comment("Codigo de usuario de modificacion")
	@Column(name = "idusuariomod", length = 20)
	private String idusuariomod;

	@Comment("Codigo de usuario de aprobacion.")
	@Column(name = "idusuarioaprobacion", length = 20)
	private String idusuarioaprobacion;

	@Comment("Fecha de ingreso del registro")
	@Column(name = "fechaingreso")
	private Instant fechaingreso;

	@Comment("Fecha de modificacion del registro")
	@Column(name = "fechamodificacion")
	private Instant fechamodificacion;

	@Comment("Fecha de Aprobacion del registro")
	@Column(name = "fechaaprobacion")
	private Instant fechaaprobacion;

	@Comment("1 catalogo activo, 0 Inactivo")
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean estado;

	@Comment("Nombre de usuario ")
	@Column(name = "username", length = 20)
	private String username;

	@Comment("Password encriptado del usuario.")
	@Column(name = "password", length = 70)
	private String password;

	@Comment("1, Indica que el usuario tiene que cambiar de password")
	@Column(name = "cambiopassword", precision = 1)
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean cambiopassword;

	@Comment("Observacion del usuario, ejemplo cuando hay cambio de estado")
	@Column(name = "observacion", length = 100)
	private String observacion;

	@OneToMany(mappedBy = "idusuario")
	private List<Usuariorol> usuariorols;

	@OneToOne(mappedBy = "usuariodetalle")
	private Usuariosession usuariosession;

}
