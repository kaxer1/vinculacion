package com.core.arnuv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Data
@Embeddable
public class UsuariosessionhistorialId implements Serializable {
    private static final long serialVersionUID = -4103935786123783465L;
    @Comment("Codigo de usuario.")
    @Column(name = "idusuario", nullable = false, length = 20)
    private String idusuario;

    @Comment("Fecha Hisotrial")
    @Column(name = "fechahistoria", nullable = false)
    private Instant fechahistoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuariosessionhistorialId entity = (UsuariosessionhistorialId) o;
        return Objects.equals(this.fechahistoria, entity.fechahistoria) &&
                Objects.equals(this.idusuario, entity.idusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechahistoria, idusuario);
    }

}
