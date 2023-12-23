import 'package:flutter/material.dart';

void mostrarExitoSnackbar( BuildContext context, String message, [int duracion = 5] ) {

  ScaffoldMessenger.of(context).hideCurrentSnackBar();
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      content: Text(message), 
      duration: Duration(seconds: duracion),
      backgroundColor: Theme.of(context).colorScheme.surface,
    )
  );
}

void mostrarErrorSnackBar( BuildContext context, String message, [int duracion = 5] ) {
  ScaffoldMessenger.of(context).hideCurrentSnackBar();
  ScaffoldMessenger.of(context).showSnackBar(
    SnackBar(
      content: Text(message), 
      duration: Duration(seconds: duracion),
      backgroundColor: Theme.of(context).colorScheme.error,
    )
  );
}