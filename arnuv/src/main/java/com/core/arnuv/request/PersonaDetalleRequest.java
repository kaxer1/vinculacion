package com.core.arnuv.request;

import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.time.Instant;

@Data
public class PersonaDetalleRequest extends RequestComun<Personadetalle> {

    @Comment("Codigo de personas")
    private Integer id;

    @Comment("Codigo de usuario de ingreso.")
    private String idusuarioing;

    @Comment("Codigo de usuario de modificacion")
    private String idusuariomod;

    @Comment("Fecha de ingreso del registro")
    private Instant fechaingreso;

    @Comment("Fecha de modificacion del registro")
    private Instant fechamodificacion;

    @Comment("Nombre de la persona")
    private String nombres;

    @Comment("Apellido de la persona")
    private String apellidos;

    @Comment("Codigo de catalogo")
    private Integer idcatalogoidentificacion;

    @Comment("Codigo de catalogo detalle")
    private String iddetalleidentificacion;

    @Comment("Identificacion, cedula, ruc, pasaporte")
    private String identificacion;

    @Comment("Numero de celular")
    private String celular;

    @Comment("Correo electronico")
    private String email;


}
