

import 'package:arnuvapp/modulos/generales/domain/domain.dart';

abstract class RecursosRepository {

  Future<List<Recursos>> listar( int limit, int page );

  Future<Recursos> crear( Recursos recursos );

  Future<Recursos> editar( Recursos recursos );

  Future<bool> eliminar( Recursos recursos );

}

