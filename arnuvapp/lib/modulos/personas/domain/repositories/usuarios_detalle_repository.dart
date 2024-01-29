
import 'package:arnuvapp/modulos/personas/domain/domain.dart';

abstract class UsuarioDetalleRepository {

  Future<List<UsuarioDetalle>> listar( int limit, int page );

  Future<UsuarioDetalle> crear( UsuarioDetalle usuario );

  Future<UsuarioDetalle> editar( UsuarioDetalle usuario );

  Future<bool> eliminar( UsuarioDetalle usuario );

}
