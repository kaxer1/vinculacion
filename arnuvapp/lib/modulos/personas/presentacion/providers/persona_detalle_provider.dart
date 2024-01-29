import 'package:arnuvapp/modulos/personas/domain/domain.dart';
import 'package:arnuvapp/modulos/personas/infraestructura/infraestructure.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';

//! 3 - StateNotifierProvider - consume afuera
final personaDetalleProvider = StateNotifierProvider.autoDispose<PersonaDetalleNotifier,PersonaDetalleState>((ref) {

  final personaDetalleRep = PersonaDetalleRepositoryImpl();

  return PersonaDetalleNotifier(
    personaDetalleRepository: personaDetalleRep
  );
});


//! 2 - Como implementamos un notifier
class PersonaDetalleNotifier extends ArnuvNotifier<PersonaDetalleState> implements ArnuvCrud<PersonaDetalle> {

  final PersonaDetalleRepository personaDetalleRepository;

  PersonaDetalleNotifier({
    required this.personaDetalleRepository,
  }): super( PersonaDetalleState(registro: personaDetalleDefault, formKey: GlobalKey<FormState>()) ) {
    listar(1, 1);  
  }

  @override
  listar(int limit, int page) async {
    try {
      final lista = await personaDetalleRepository.listar(limit, page);
      state = state.copyWith(
        lregistros: lista
      );
    } on PersonaException catch (e) {
      super.setMensajeError(e.message);
    }
  }
  
  @override
  actualizar(PersonaDetalle reg) async {
    try {
      await personaDetalleRepository.editar(state.registro);
    } on PersonaException catch (e) {
      super.setMensajeError(e.message);
    }
  }
  
  @override
  guardar() async {
    try {
      await personaDetalleRepository.crear(state.registro);
    } on PersonaException catch (e) {
      super.setMensajeError(e.message);
    }
  }
  
  @override
  eliminar(PersonaDetalle reg) {
    // print("METODO DE ELIMINAR PROVIDER ${reg.apellidos }");
  }
  
  @override
  limpiarRegistro() {
    state = state.copyWith(registro: personaDetalleDefault, esValidoForm: false);
  }
  
  @override
  seleccionaRegistro(PersonaDetalle reg) {
    state = state.copyWith(registro: reg, esValidoForm: false);
  }

  esFormularioValido() {
    state = state.copyWith( esValidoForm: false );
    if (state.formKey.currentState?.validate() != true) return;
    state = state.copyWith( esValidoForm: true );
  }

}


//! 1 - State del provider
class PersonaDetalleState extends ArnuvState {

  final List<PersonaDetalle> lregistros;
  final PersonaDetalle registro;
  final bool esValidoForm;
  GlobalKey<FormState> formKey;

  PersonaDetalleState({
    this.lregistros = const [],
    required this.registro,
    this.esValidoForm = false,
    required this.formKey,
    super.errorMessage
  });

  PersonaDetalleState copyWith({
    List<PersonaDetalle>? lregistros,
    PersonaDetalle? registro,
    bool? esValidoForm,
    GlobalKey<FormState>? formKey
  }) => PersonaDetalleState(
    lregistros: lregistros ?? this.lregistros,
    registro: registro ?? this.registro,
    esValidoForm: esValidoForm ?? this.esValidoForm,
    formKey: formKey ?? this.formKey,
  );
  
  @override
  ArnuvState copyWithArnuv({String? errorMessage}) => PersonaDetalleState(
    formKey: formKey,
    registro: personaDetalleDefault,
    errorMessage: errorMessage ?? super.errorMessage
  );

}
