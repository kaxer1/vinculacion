import 'package:arnuvapp/modulos/autenticacion/domain/domain.dart';
import 'package:arnuvapp/modulos/autenticacion/infraestructura/infrastructure.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';

class AuthDataSourceImpl extends AuthDataSource with ArnuvServicios {

  @override
  Future<User> login(String username, String password) async {
    final response = await postServicio('/api/autenticacion/login', data: {
      'serial': await getUuid(true),
      'username': username,
      'password': password
    });
  
    print(response);
    // return UserMapper.userJsonToEntity(response.data); 
    return User(username: username);
  }
  
  @override
  Future<User> checkLogin() async {
    final response = await postServicio('/api/autenticacion/menu', data: {
      'serial': await getUuid(true)
    });

    return UserMapper.userJsonToEntity(response.data);
  }
  
}
