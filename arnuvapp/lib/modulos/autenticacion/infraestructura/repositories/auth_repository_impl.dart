

import 'package:arnuvapp/modulos/autenticacion/domain/domain.dart';
import '../infrastructure.dart';


class AuthRepositoryImpl extends AuthRepository {

  final AuthDataSource dataSource;

  AuthRepositoryImpl({
    AuthDataSource? dataSource
  }) : dataSource = dataSource ?? AuthDataSourceImpl();

  @override
  Future<User> login(String username, String password) {
    return dataSource.login(username, password);
  }
  
  @override
  Future<User> checkLogin() {
    return dataSource.checkLogin();
  }

}