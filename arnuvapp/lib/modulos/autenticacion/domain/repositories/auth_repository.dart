
import 'package:arnuvapp/modulos/autenticacion/domain/domain.dart';

abstract class AuthRepository {

  Future<User> login( String username, String password );
  
  Future<MenuResponse> checkMenuLogin();

}

