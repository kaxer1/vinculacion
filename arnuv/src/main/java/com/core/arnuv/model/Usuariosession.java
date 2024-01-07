package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.NumericBooleanConverter;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Comment("Tabla que almacena sessiones de usuario, cuando este esta conectado a  la aplicacion")
@Entity
@Table(name = "usuariosession")
public class Usuariosession {

	@Id
	@Comment("Codigo de usuario.")
	@Column(name = "idusuario", nullable = false)
	private Integer idusuario;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@Comment("Codigo de usuario.")
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JoinColumn(name = "idusuario")
	private Usuariodetalle usuariodetalle;

	@Comment("Numero de intentos de login")
	@Column(name = "numerointentos", precision = 2)
	private BigDecimal numerointentos;

	@Comment("ID de la session del browser o movil")
	@Column(name = "idsession", length = 70)
	private String idsession;

	@Comment("Fecha de inicio de la session")
	@Column(name = "fechainicio")
	private Instant fechainicio;

	@Comment("Fecha de cierre de la session")
	@Column(name = "fechasalida")
	private Instant fechasalida;

	@Comment("1 Indica que el usuario realizo un login a la aplicacion y mantien la aplicacion activa, 0 el usuario esta fuera de la aplicacion.")
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean activo;

	@Comment("I(usuario realiza login con exito), F(Intento fallido de login), L(Usuario relizo logout), S(Sistema realizo logout por inactividad)")
	@Column(name = "estado", length = 1)
	private String estado;

	@Comment("identificacion del dispositivo que ingresa el usuario")
	@Column(name = "useragent", length = 200)
	private String useragent;

	@Comment("Codigo de terminal publico o privado con la que sale la peticon del usuario, IPV4 y IPV6")
	@Column(name = "iptermialremoto", length = 130)
	private String iptermialremoto;

}
