import 'package:arnuvapp/modulos/generales/domain/domain.dart';
import 'package:arnuvapp/modulos/generales/infraestructura/infraestructure.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';

class CatalogoDataSourceImpl extends CatalogoDataSource with ArnuvServicios {
  
  @override
  Future<Catalogo> crear(Catalogo catalogo) async {
    try {
      final data = CatalogoMapper.entityToJsonData(catalogo);
      final response = await postServicio('/personas/crear', data: data);
      var resp = Catalogo.fromJson(response.data["dto"]);
      return resp;
    } on SystemException catch (e) {
      throw GeneralesException(e.message);
    }
  }

  @override
  Future<Catalogo> editar(Catalogo catalogo) async {
    try {
      final data = CatalogoMapper.entityToJsonData(catalogo);
      final response = await putServicio('/personas/actualizar', data: data );
      var resp = Catalogo.fromJson(response.data["dto"]);
      return resp;
    } on SystemException catch (e) {
      throw GeneralesException(e.message);
    }
  }

  @override
  Future<bool> eliminar(Catalogo catalogo) {
    // TODO: implement eliminar
    throw UnimplementedError();
  }

  @override
  Future<List<Catalogo>> listar(int limit, int page) async {
    try {
      final response = await getServicio('/personas/listar');
      var resp = CatalogoMapper.listPersonaJsonToList(response.data["lista"]);
      return resp;
    } on SystemException catch (e) {
      throw GeneralesException(e.message);
    }
  }
  
}
