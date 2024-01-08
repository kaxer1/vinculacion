import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:arnuvapp/modulos/autenticacion/domain/domain.dart';
import 'package:arnuvapp/modulos/autenticacion/infraestructura/infrastructure.dart';
import 'package:arnuvapp/modulos/shared/infrastructure/services/key_value_storage_service.dart';
import 'package:arnuvapp/modulos/shared/infrastructure/services/key_value_storage_service_impl.dart';
import 'package:arnuvapp/modulos/shared/utils/arnuv_provider.dart';


final authProvider = StateNotifierProvider<AuthNotifier,AuthState>((ref) {

  final authRepository = AuthRepositoryImpl();
  final keyValueStorageService = KeyValueStorageServiceImpl();


  return AuthNotifier(
    authRepository: authRepository,
    keyValueStorageService: keyValueStorageService
  );
});



class AuthNotifier extends ArnuvNotifier<AuthState>  {

  final AuthRepository authRepository;
  final KeyValueStorageService keyValueStorageService;

  AuthNotifier({
    required this.authRepository,
    required this.keyValueStorageService,
  }): super( AuthState() ) {
    checkLogin();
  }

  void checkLogin() async {
    final token = await keyValueStorageService.getValue<String>('token');
    if( token == null ) return logout();

    try {
      final user = await authRepository.checkLogin();
      _setUsuarioLogeado(user);

    } on SystemException catch (e) {
      logout( e.message );
    } catch (e) {
      logout(e.toString());
    }

  }

  Future<void> loginUser( String username, String password, dynamic context ) async {
    super.showLoading(context);
    await Future.delayed(const Duration(seconds: 1));

    try {
      final user = await authRepository.login(username, password);
      _setUsuarioLogeado( user );

    } on SystemException catch (e) {
      logout( e.message );
    } catch (e){
      logout( 'Error no controlado' );
    }
    super.clouseLoading(context);

  }

  void registerUser( String email, String password ) async {
    
  }

  void _setUsuarioLogeado( User user ) async {
    try {
      await keyValueStorageService.setKeyValue<String>('token', "");
      state = state.copyWith(
        user: user,
        authStatus: AuthStatus.authenticated,
      );
    } catch (e) {
      setMensajeError(e.toString());
    }
  }

  Future<void> logout([ String? errorMessage ]) async {
    
    await keyValueStorageService.removeKey('token');

    state = state.copyWith(
      authStatus: AuthStatus.notAuthenticated,
      user: null,
    );
    setMensajeError(errorMessage);
  }

}

enum AuthStatus { checking, authenticated, notAuthenticated }

class AuthState extends ArnuvState {

  final AuthStatus authStatus;
  final User? user;

  AuthState({
    this.authStatus = AuthStatus.checking, 
    this.user,
    super.errorMessage
  });

  AuthState copyWith({
    AuthStatus? authStatus,
    User? user,
  }) => AuthState(
    authStatus: authStatus ?? this.authStatus,
    user: user ?? this.user,
  );

  AuthState limpiarState() => AuthState(
    user: null,
    authStatus: AuthStatus.checking,
    errorMessage: ""
  );
  
  @override
  ArnuvState copyWithArnuv({String? errorMessage}) => AuthState(
    errorMessage: errorMessage ?? super.errorMessage
  );

}