package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Data
@Comment("Tabla que almacena los roles asociados a un usuario")
@Entity
@Table(name = "usuariorol")
public class Usuariorol {
    @EmbeddedId
    private UsuariorolId id;

    @MapsId("idrol")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Comment("Codigo de rol")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idrol", nullable = false)
    private Rol idrol;

    @MapsId("idusuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Comment("Codigo de usuario.")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuariodetalle idusuario;

    @Comment("Codigo de usuario de ingreso.")
    @Column(name = "idususarioing", length = 20)
    private String idususarioing;

    @Comment("Codigo de usuario de modificacion")
    @Column(name = "idususariomod", length = 20)
    private String idususariomod;

    @Comment("Fecha de ingreso del registro")
    @Column(name = "fechaingreso")
    private Instant fechaingreso;

    @Comment("Fecha de modificacion del registro")
    @Column(name = "fechamodificacion")
    private Instant fechamodificacion;

}
