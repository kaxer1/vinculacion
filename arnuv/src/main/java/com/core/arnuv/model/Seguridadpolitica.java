package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.List;

@Data
@Comment("Tabla que almacena la politica de seguridad")
@Entity
@Table(name = "seguridadpolitica")
public class Seguridadpolitica {
    @Id
    @Comment("Codigo de politica")
    @Column(name = "idpolitica", nullable = false)
    private Integer id;

    @Comment("Longitud minima del password")
    @Column(name = "longitud", precision = 2)
    private BigDecimal longitud;

    @Comment("Numero de ingresos de password erroneo para bloquear al usuario")
    @Column(name = "intentos", precision = 2)
    private BigDecimal intentos;

    @Comment("Canridad minima de numeros que requiere el password")
    @Column(name = "numeros", precision = 2)
    private BigDecimal numeros;

    @Comment("Numero de caracteres minimos que requeiere el password")
    @Column(name = "especiales", precision = 2)
    private BigDecimal especiales;

    @Comment("Cantidad de letras en minusculas que requeire el password")
    @Column(name = "minusculas", precision = 2)
    private BigDecimal minusculas;

    @Comment("Cantidad de letras en mayusculas que requiere el password")
    @Column(name = "mayusculas", precision = 2)
    private BigDecimal mayusculas;

    @Comment("Tiempo de Regeracion delToken en minutos")
    @Column(name = "tiemporegeraciontoken", precision = 3)
    private BigDecimal tiemporegeraciontoken;

    @OneToMany(mappedBy = "idpolitica")
    private List<Rol> rols;

}
