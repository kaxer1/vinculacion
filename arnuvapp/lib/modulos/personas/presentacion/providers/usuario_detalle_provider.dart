import 'package:arnuvapp/modulos/personas/domain/domain.dart';
import 'package:arnuvapp/modulos/personas/infraestructura/infraestructure.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';

//! 3 - StateNotifierProvider - consume afuera
final usuarioDetalleProvider = StateNotifierProvider.autoDispose<UsuarioDetalleNotifier,UsuarioDetalleState>((ref) {

  final repository = UsuarioDetalleRepositoryImpl();

  return UsuarioDetalleNotifier(
    usuarioRepository: repository
  );
});


//! 2 - Como implementamos un notifier
class UsuarioDetalleNotifier extends ArnuvNotifier<UsuarioDetalleState> implements ArnuvCrud<UsuarioDetalle> {

  final UsuarioDetalleRepository usuarioRepository;

  UsuarioDetalleNotifier({
    required this.usuarioRepository,
  }): super( UsuarioDetalleState(registro: usuarioDetalleDefault, formKey: GlobalKey<FormState>()) ) {
    listar(1, 1);  
  }

  @override
  listar(int limit, int page) async {
    try {
      final lista = await usuarioRepository.listar(limit, page);
      state = state.copyWith(
        lregistros: lista
      );
    } on PersonaException catch (e) {
      super.setMensajeError(e.message);
    }
  }
  
  @override
  actualizar(UsuarioDetalle reg) async {
    try {
      await usuarioRepository.editar(state.registro);
    } on PersonaException catch (e) {
      super.setMensajeError(e.message);
    }
  }
  
  @override
  guardar() async {
    try {
      await usuarioRepository.crear(state.registro);
    } on PersonaException catch (e) {
      super.setMensajeError(e.message);
    }
  }
  
  @override
  eliminar(UsuarioDetalle reg) {
    // print("METODO DE ELIMINAR PROVIDER ${reg.apellidos }");
  }
  
  @override
  limpiarRegistro() {
    state = state.copyWith(registro: usuarioDetalleDefault, esValidoForm: false);
  }
  
  @override
  seleccionaRegistro(UsuarioDetalle reg) {
    state = state.copyWith(registro: reg, esValidoForm: false);
  }

  esFormularioValido() {
    state = state.copyWith( esValidoForm: false );
    if (state.formKey.currentState?.validate() != true) return;
    state = state.copyWith( esValidoForm: true );
  }

}


//! 1 - State del provider
class UsuarioDetalleState extends ArnuvState {

  final List<UsuarioDetalle> lregistros;
  final UsuarioDetalle registro;
  final bool esValidoForm;
  GlobalKey<FormState> formKey;

  UsuarioDetalleState({
    this.lregistros = const [],
    required this.registro,
    this.esValidoForm = false,
    required this.formKey,
    super.errorMessage
  });

  UsuarioDetalleState copyWith({
    List<UsuarioDetalle>? lregistros,
    UsuarioDetalle? registro,
    bool? esValidoForm,
    GlobalKey<FormState>? formKey
  }) => UsuarioDetalleState(
    lregistros: lregistros ?? this.lregistros,
    registro: registro ?? this.registro,
    esValidoForm: esValidoForm ?? this.esValidoForm,
    formKey: formKey ?? this.formKey,
  );
  
  @override
  ArnuvState copyWithArnuv({String? errorMessage}) => UsuarioDetalleState(
    formKey: formKey,
    registro: usuarioDetalleDefault,
    errorMessage: errorMessage ?? super.errorMessage
  );

}
