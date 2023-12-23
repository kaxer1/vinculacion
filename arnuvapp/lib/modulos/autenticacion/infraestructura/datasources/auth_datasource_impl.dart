import 'package:arnuvapp/modulos/autenticacion/domain/domain.dart';
import 'package:arnuvapp/modulos/autenticacion/infraestructura/infrastructure.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';

class AuthDataSourceImpl extends AuthDataSource with ArnuvServicios {

  @override
  Future<User> login(String username, String password) async {
    final response = await postServicio('/auth/validarlogin', data: {
      'serial': await getUuid(true),
      'username': username,
      'password': password
    });
  
    return UserMapper.userJsonToEntity(response.data); 
  }
  
  @override
  Future<User> checkLogin() async {
    final response = await postServicio('/auth/validarlogin', data: {
      'serial': await getUuid(true)
    });

    return UserMapper.userJsonToEntity(response.data);
  }
  
}
