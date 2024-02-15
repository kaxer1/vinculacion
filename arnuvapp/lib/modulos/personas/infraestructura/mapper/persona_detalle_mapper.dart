


import 'package:arnuvapp/modulos/generales/domain/entities/catalogo_detalle_response.dart';
import 'package:arnuvapp/modulos/personas/domain/domain.dart';
import 'package:arnuvapp/modulos/shared/infrastructure/errors/system_errors.dart';

class PersonaDetalleMapper {

  static List<PersonaDetalle> listPersonaJsonToList( List<dynamic> ljson ) {
    try {
      var lresult = ljson.map((e) => personaJsonToEntity(e));
      return List<PersonaDetalle>.from(lresult);
    } catch (e) {
      throw SystemException( e.toString());
    }
  }

  static PersonaDetalle personaJsonToEntity(Map<String, dynamic> json) => PersonaDetalle(
        id: json["id"],
        idusuarioing: json["idusuarioing"] == null ? "" : json["idusuarioing"],
        idusuariomod: json["idusuariomod"] == null ? "" : json["idusuariomod"],
        fechaingreso: json["fechaingreso"] == null ? DateTime.now() : DateTime.tryParse(json["fechaingreso"]) ?? DateTime.now(),
        fechamodificacion: json["fechamodificacion"] == null ? DateTime.now() : DateTime.tryParse(json["fechamodificacion"]) ?? DateTime.now(),
        nombres: json["nombres"],
        apellidos: json["apellidos"],
        catalogodetalle: CatalogoDetalle.fromJson(json["catalogodetalle"]),
        identificacion: json["identificacion"],
        celular: json["celular"] == null ? "" : json["celular"],
        email: json["email"] == null ? "" : json["email"],
    );
  
  static Map<String, dynamic> entityToJsonData(PersonaDetalle persona) {
    var mapa = <String, dynamic>{};
        mapa.addAll({"id": persona.id} );
        mapa.addAll({"idusuarioing": persona.idusuarioing });
        mapa.addAll({"idusuariomod": persona.idusuariomod });
        mapa.addAll({"fechaingreso": persona.fechaingreso.toIso8601String() });
        mapa.addAll({"fechamodificacion": persona.fechaingreso.toIso8601String() });
        mapa.addAll({"nombres": persona.nombres });
        mapa.addAll({"apellidos": persona.apellidos });
        mapa.addAll({"idcatalogoidentificacion": persona.catalogodetalle.id.idcatalogo });
        mapa.addAll({"iddetalleidentificacion": persona.catalogodetalle.id.iddetalle });
        mapa.addAll({"identificacion": persona.identificacion });
        mapa.addAll({"celular": persona.celular });
        mapa.addAll({"email": persona.email });
    return mapa;
  } 

}

