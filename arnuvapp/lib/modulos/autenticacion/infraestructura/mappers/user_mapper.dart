
import 'package:arnuvapp/modulos/autenticacion/domain/domain.dart';
import '../errors/auth_errors.dart';


class UserMapper {

  static User userJsonToEntity( Map<String,dynamic> json ) {
    try {
      return User( username: json['username'] );
    } catch (e) {
      throw SystemException( e.toString());
    }
  } 

}

