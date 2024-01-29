import 'package:flutter/material.dart';

class InputDecorations {

  static InputDecoration inputDecorationPersonalizado({
    required String hintText,
    required String labelText,
    double? labelFontSize,
    IconData? prefixIcon,
    IconData? suffixIcon,
    Function? onTap
  }) {
    const colorDecoration = Color.fromRGBO(179, 0, 255, 1);
    return InputDecoration(
      contentPadding: const EdgeInsets.symmetric(vertical: 2, horizontal: 20),
      enabledBorder: const OutlineInputBorder(
        borderSide: BorderSide(
          color: colorDecoration,
        ),
        borderRadius: BorderRadius.all(Radius.circular(15)),
      ),
      focusedBorder: const OutlineInputBorder(
        borderSide: BorderSide(
          color: colorDecoration,
          width: 2
        ),
        borderRadius: BorderRadius.all(Radius.circular(15)),
      ),
      hintText: hintText,
      labelText: labelText,
      labelStyle: TextStyle(
        color: const Color.fromARGB(255, 66, 66, 66),
        fontSize: labelFontSize
      ),
      errorBorder: const OutlineInputBorder(
        borderSide: BorderSide(
          color: Colors.red,
        ),
        borderRadius: BorderRadius.all(Radius.circular(15)),
      ),
      focusedErrorBorder:  const OutlineInputBorder(
        borderSide: BorderSide(
          color: Colors.red,
          width: 2
        ),
        borderRadius: BorderRadius.all(Radius.circular(15)),
      ),
      prefixIcon: prefixIcon != null 
        ? GestureDetector(onTap: onTap as void Function()?, child: Icon( prefixIcon, color: colorDecoration ))
        : null,
      suffixIcon : suffixIcon != null 
        ? GestureDetector(onTap: onTap as void Function()?, child: Icon( suffixIcon, color: colorDecoration ))
        : null
    );
  }  

}