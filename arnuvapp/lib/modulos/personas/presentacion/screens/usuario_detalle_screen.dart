

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:arnuvapp/modulos/personas/presentacion/providers/providers.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';
import 'package:flutter/material.dart';

class UsuarioDetalleScreen extends ConsumerWidget {
  const UsuarioDetalleScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final localizations = AppLocalizations.of(context);
    final lregistros = ref.watch(usuarioDetalleProvider).lregistros;

    ref.listen(usuarioDetalleProvider, (ArnuvState? previous , ArnuvState next) {
      if ( next.errorMessage.isEmpty ) return;
      mostrarErrorSnackBar( context, next.errorMessage, ref );
    });

    return Scaffold(
      appBar: AppBar(title: Text(localizations.translate('AppTitUsuario')) ),
        body: Column(
          
          children: [
            DataTableArnuv(nombreTabla: "Tabla Usuarios",
            columnsName: const ['Id Usuario', 'Username','Nombre'],
            onNew: () {
              ref.watch(usuarioDetalleProvider.notifier).limpiarRegistro();
              dialogRegister(context: context,
                children: [_Formulario( onPressedOk: () {
                  ref.watch(usuarioDetalleProvider.notifier).guardar();
                  Navigator.pop(context);
                })],
              );
            },
            onDelete: (index) {
              aletaEliminaReg(context: context,
                onPressedOk: () {
                  ref.watch(usuarioDetalleProvider.notifier).eliminar(lregistros[index]);
                  Navigator.pop(context);
                },
              );
            },
            onEdit: (index) {
              ref.watch(usuarioDetalleProvider.notifier).seleccionaRegistro(lregistros[index]);
              dialogRegister(context: context,
                esregistrar: false,
                children: [_Formulario(
                    onPressedOk: () {
                    ref.watch(usuarioDetalleProvider.notifier).actualizar(lregistros[index]);
                    Navigator.pop(context);
                  }
                )],
              );
            },
            rowTablas: [...lregistros.map((e) {
                  List<Widget> lista = [];
                  lista.add(Text(e.idusuario.toString()));
                  lista.add(Text(e.username));
                  lista.add(Text(e.idpersona.nombres));
                  return lista;
                })],
            ),

          ]
        )
    );
  }
}

class _Formulario extends ConsumerWidget {

  final Function()? onPressedOk;

  const _Formulario({
    required this.onPressedOk
  });


  @override
  Widget build(BuildContext context, WidgetRef ref) {

    final localizations = AppLocalizations.of(context);
    final state = ref.watch(usuarioDetalleProvider);
    final metodos = ref.read(usuarioDetalleProvider.notifier);
    
    final valiacion = ValidacionesInputUtil(localizations: localizations);
    return Column(
      children: [
        Form(
          autovalidateMode: AutovalidateMode.onUserInteraction,
          key: state.formKey,
          onChanged: metodos.esFormularioValido,
          child: Column(
            children: [
              InputTexto(
                initialValue: state.registro.username,
                textInputType: TextInputType.text,
                label: localizations.translate('lblNombres'),
                maxLength: 120,
                onChange: (value) => state.registro.username = value,          
                validacion: (valor) => valiacion.validarSoloLetras(valor)
              ),
              
              
              BotonesForm(
                esValidoForm: state.esValidoForm, 
                onPressedOk: onPressedOk
              )
              
            ],
          )
        
        )

      ],
    );
  }
}

