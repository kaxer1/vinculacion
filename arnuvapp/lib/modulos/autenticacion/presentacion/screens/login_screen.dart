import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:arnuvapp/modulos/autenticacion/presentacion/providers/providers.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';


class LoginScreen extends StatelessWidget {
  const LoginScreen({super.key});

  @override
  Widget build(BuildContext context) {
    
    return GestureDetector(
      onTap: () => FocusManager.instance.primaryFocus?.unfocus(),
      child: const Scaffold(
        body: InicioBackground(
          child: SingleChildScrollView(
            physics: const ClampingScrollPhysics(),
            child: Column(
              children: [
                const SizedBox( height: 200 ),
                
                CardContainer(
                  height: 270,
                  child: const _LoginForm(),
                )  
              ],
            ),
          ),
        ),
      )
    );
  }
}

class _LoginForm extends ConsumerWidget {

  const _LoginForm();


  @override
  Widget build(BuildContext context, WidgetRef ref) {

    final loginForm = ref.watch(loginFormProvider);
    final localizations = AppLocalizations.of(context);

    ref.listen(authProvider, (ArnuvState? previous , ArnuvState next) {
      if ( next.errorMessage.isEmpty ) return;
      mostrarErrorSnackBar( context, next.errorMessage );
    });

    return Column(
      children: [
        const SizedBox(height: 10),
        InputTexto(
          textInputType: TextInputType.text,
          label: localizations.translate('lblUsuario'),
          prefixIcon: Icons.person_outline,
          maxLength: 16,
          onChange: ref.read(loginFormProvider.notifier).onUsernameChange,
          // validacion: (value) => ValidacionesInputs.validarNombreUsuario(value.toString(), 'validarUsernameLogin'),
        ),
        const SizedBox(height: 20),
        InputTextoOculto(
          mostrarTexto: ref.read(loginFormProvider).mostrarTextoContrasenia,
          label: localizations.translate('lblContrasenia'),
          prefixIcon: Icons.lock_outline,
          maxLength: 16,
          onChange: ref.read(loginFormProvider.notifier).onPasswordChanged,
          // validacion: (value) => ValidacionesInputs.validarContrasenia(value),
          onTapIcon: ref.read(loginFormProvider.notifier).onMostrarContrasenia,
        ),
        
        BotonPrimario(
          onPressed: loginForm.esValido 
            ? () => ref.read(loginFormProvider.notifier).onFormSubmit(context)
            : null,
          label: localizations.translate('btnLogin'),
          mt: 20,
        ),

      ],
    );
  }
}