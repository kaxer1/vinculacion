import 'package:flutter/material.dart';
import 'package:arnuvapp/config/router/const_routes.dart';


class MenuItem {
  final String title;
  final String subTitle;
  final String link;
  final IconData icon;

  const MenuItem({
    required this.title,
    required this.subTitle,
    required this.link,
    required this.icon
  });
}


const appMenuItems = <MenuItem>[

  MenuItem(
    title: 'Botones', 
    subTitle: 'Varios botones en Flutter', 
    link: ConstRoutes.NAVEGACION, 
    icon: Icons.smart_button_outlined
  ),

  MenuItem(
    title: 'Progress Indicators', 
    subTitle: 'Generales y controlados', 
    link: ConstRoutes.IDIOMA, 
    icon: Icons.refresh_rounded
  ),


];