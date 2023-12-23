import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:formz/formz.dart';
import 'package:arnuvapp/modulos/autenticacion/presentacion/providers/autenticacion_provider.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';

//! 3 - StateNotifierProvider - consume afuera
final loginFormProvider = StateNotifierProvider.autoDispose<LoginFormNotifier,LoginFormState>((ref) {

  final loginUserCallback = ref.watch(authProvider.notifier).loginUser;

  return LoginFormNotifier(
    loginUserCallback:loginUserCallback
  );
});


//! 2 - Como implementamos un notifier
class LoginFormNotifier extends StateNotifier<LoginFormState> {

  final Function(String, String, dynamic context) loginUserCallback;

  LoginFormNotifier({
    required this.loginUserCallback,
  }): super( LoginFormState() );
  
  // onEmailChange( String value ) {
  //   final newEmail = Email.dirty(value);
  //   state = state.copyWith(
  //     email: newEmail,
  //     esValido: Formz.validate([ newEmail, state.password ])
  //   );
  // }

  onUsernameChange( String value ) {
    state = state.copyWith(
      username: value,
      esValido: true
    );
  }

  onPasswordChanged( String value ) {
    final newPassword = Password.dirty(value);
    state = state.copyWith(
      password: newPassword,
      esValido: Formz.validate([ newPassword ])
      // esValido: Formz.validate([ newPassword, state.email ])
    );
  }

  onMostrarContrasenia() {
    state = state.copyWith(
      mostrarTextoContrasenia: !state.mostrarTextoContrasenia
    );
  }

  Function onCheckChange( bool? value ) {
    state = state.copyWith(
      esAceptoTerminos: value,
    );
    return (){};
  }


  onFormSubmit(context) async {
    _touchEveryField();

    if ( !state.esValido && !state.esAceptoTerminos ) return;

    await loginUserCallback( state.username, ArnuvUtils.hashSHA256(state.password.value), context);

  }

  _touchEveryField() {

    final email    = Email.dirty(state.email.value);
    final password = Password.dirty(state.password.value);

    state = state.copyWith(
      email: email,
      password: password,
      // esValido: Formz.validate([ email, password ])
    );

  }

}


//! 1 - State del provider
class LoginFormState {

  final bool esAceptoTerminos;
  final bool esValido;
  final Email email;
  final String username;
  final Password password;
  final bool mostrarTextoContrasenia;

  LoginFormState({
    this.esAceptoTerminos = false,
    this.esValido = false,
    this.email = const Email.pure(),
    this.username = '',
    this.password = const Password.pure(),
    this.mostrarTextoContrasenia = true,
  });

  LoginFormState copyWith({
    bool? esAceptoTerminos,
    bool? esValido,
    Email? email,
    String? username,
    Password? password,
    bool? mostrarTextoContrasenia
  }) => LoginFormState(
    esAceptoTerminos: esAceptoTerminos ?? this.esAceptoTerminos,
    esValido: esValido ?? this.esValido,
    email: email ?? this.email,
    username: username ?? this.username,
    password: password ?? this.password,
    mostrarTextoContrasenia: mostrarTextoContrasenia ?? this.mostrarTextoContrasenia,
  );

  @override
  String toString() {
    return '''
  LoginFormState:
    esAceptoTerminos: $esAceptoTerminos
    esValido: $esValido
    email: $email
    username: $username
    password: $password
    mostrarTextoContrasenia: $mostrarTextoContrasenia
''';
  }
}
