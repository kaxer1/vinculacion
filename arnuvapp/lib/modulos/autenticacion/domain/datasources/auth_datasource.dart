import 'package:arnuvapp/modulos/autenticacion/domain/domain.dart';

abstract class AuthDataSource {

  Future<User> login( String username, String password );

  Future<MenuResponse> checkMenuLogin();

}

