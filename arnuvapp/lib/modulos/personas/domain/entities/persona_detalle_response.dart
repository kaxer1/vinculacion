import 'dart:convert';

PersonaDetalleResponse personaResponseFromJson(String str) => PersonaDetalleResponse.fromJson(json.decode(str));

String personaResponseToJson(PersonaDetalleResponse data) => json.encode(data.toJson());

class PersonaDetalleResponse {
    dynamic mensaje;
    dynamic codigo;
    dynamic dto;
    List<PersonaDetalle> lista;

    PersonaDetalleResponse({
        this.mensaje,
        this.codigo,
        this.dto,
        required this.lista,
    });

    factory PersonaDetalleResponse.fromJson(Map<String, dynamic> json) => PersonaDetalleResponse(
        mensaje: json["mensaje"],
        codigo: json["codigo"],
        dto: json["dto"],
        lista: List<PersonaDetalle>.from(json["lista"].map((x) => PersonaDetalle.fromJson(x))),
    );

    Map<String, dynamic> toJson() => {
        "mensaje": mensaje,
        "codigo": codigo,
        "dto": dto,
        "lista": List<dynamic>.from(lista.map((x) => x.toJson())),
    };
}

class PersonaDetalle {
    int id;
    String? idusuarioing;
    String? idusuariomod;
    String? fechaingreso;
    String? fechamodificacion;
    String nombres;
    String apellidos;
    Catalogodetalle catalogodetalle;
    String identificacion;
    String celular;
    String email;

    PersonaDetalle({
        required this.id,
        this.idusuarioing,
        this.idusuariomod,
        this.fechaingreso,
        this.fechamodificacion,
        required this.nombres,
        required this.apellidos,
        required this.catalogodetalle,
        required this.identificacion,
        required this.celular,
        required this.email,
    });

    PersonaDetalle copyWith({
        int? id,
        dynamic idusuarioing,
        dynamic idusuariomod,
        dynamic fechaingreso,
        dynamic fechamodificacion,
        String? nombres,
        String? apellidos,
        Catalogodetalle? catalogodetalle,
        String? identificacion,
        String? celular,
        String? email,
    }) => 
        PersonaDetalle(
            id: id ?? this.id,
            idusuarioing: idusuarioing ?? this.idusuarioing,
            idusuariomod: idusuariomod ?? this.idusuariomod,
            fechaingreso: fechaingreso ?? this.fechaingreso,
            fechamodificacion: fechamodificacion ?? this.fechamodificacion,
            nombres: nombres ?? this.nombres,
            apellidos: apellidos ?? this.apellidos,
            catalogodetalle: catalogodetalle ?? this.catalogodetalle,
            identificacion: identificacion ?? this.identificacion,
            celular: celular ?? this.celular,
            email: email ?? this.email,
        );

    factory PersonaDetalle.fromJson(Map<String, dynamic> json) => PersonaDetalle(
        id: json["id"],
        idusuarioing: json["idusuarioing"],
        idusuariomod: json["idusuariomod"],
        fechaingreso: json["fechaingreso"],
        fechamodificacion: json["fechamodificacion"],
        nombres: json["nombres"],
        apellidos: json["apellidos"],
        catalogodetalle: Catalogodetalle.fromJson(json["catalogodetalle"]),
        identificacion: json["identificacion"],
        celular: json["celular"],
        email: json["email"],
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "idusuarioing": idusuarioing,
        "idusuariomod": idusuariomod,
        "fechaingreso": fechaingreso,
        "fechamodificacion": fechamodificacion,
        "nombres": nombres,
        "apellidos": apellidos,
        "catalogodetalle": catalogodetalle.toJson(),
        "identificacion": identificacion,
        "celular": celular,
        "email": email,
    };
}

class Catalogodetalle {
    Id id;
    String nombre;
    bool activo;

    Catalogodetalle({
        required this.id,
        required this.nombre,
        required this.activo,
    });

    Catalogodetalle copyWith({
        Id? id,
        String? nombre,
        bool? activo,
    }) => 
        Catalogodetalle(
            id: id ?? this.id,
            nombre: nombre ?? this.nombre,
            activo: activo ?? this.activo,
        );

    factory Catalogodetalle.fromJson(Map<String, dynamic> json) => Catalogodetalle(
        id: Id.fromJson(json["id"]),
        nombre: json["nombre"],
        activo: json["activo"],
    );

    Map<String, dynamic> toJson() => {
        "id": id.toJson(),
        "nombre": nombre,
        "activo": activo,
    };

}

class Id {
    int idcatalogo;
    String iddetalle;

    Id({
        required this.idcatalogo,
        required this.iddetalle,
    });

     Id copyWith({
        int? idcatalogo,
        String? iddetalle,
    }) => 
        Id(
            idcatalogo: idcatalogo ?? this.idcatalogo,
            iddetalle: iddetalle ?? this.iddetalle,
        );

    factory Id.fromJson(Map<String, dynamic> json) => Id(
        idcatalogo: json["idcatalogo"],
        iddetalle: json["iddetalle"],
    );

    Map<String, dynamic> toJson() => {
        "idcatalogo": idcatalogo,
        "iddetalle": iddetalle,
    };
}

final personaDetalleDefault = PersonaDetalle(
        id: 0,
        idusuarioing: '',
        idusuariomod: '',
        fechaingreso: '',
        fechamodificacion: '',
        nombres: '',
        apellidos: '',
        catalogodetalle: Catalogodetalle(
          id: Id(idcatalogo: 1, iddetalle: ''), 
          nombre: '', 
          activo: true
        ),
        identificacion: '',
        celular: '',
        email: '',
    );