import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:arnuvapp/config/menu/menu_items.dart';
import 'package:arnuvapp/modulos/autenticacion/autenticacion.dart';

import 'package:arnuvapp/modulos/shared/shared.dart';

class SideMenu extends ConsumerStatefulWidget {

  final GlobalKey<ScaffoldState> scaffoldKey;

  const SideMenu({
    super.key, 
    required this.scaffoldKey
  });

  @override
  SideMenuState createState() => SideMenuState();
}

class SideMenuState extends ConsumerState<SideMenu> {

  int navDrawerIndex = 0;

  @override
  Widget build(BuildContext context) {

    final hasNotch = MediaQuery.of(context).viewPadding.top > 35;
    final textStyles = Theme.of(context).textTheme;
    final user = ref.watch(authProvider).user;
    

    return NavigationDrawer(
      elevation: 1,
      selectedIndex: navDrawerIndex,
      onDestinationSelected: (value) {

        setState(() {
          navDrawerIndex = value;
        });

        final menuItem = appMenuItems[value];
        context.push( menuItem.link );
        widget.scaffoldKey.currentState?.closeDrawer();

      },
      children: [

        Padding(
          padding: EdgeInsets.fromLTRB(20, hasNotch ? 0 : 20, 16, 0),
          child: Text('Saludos', style: textStyles.titleMedium ),
        ),

        Padding(
          padding: const EdgeInsets.fromLTRB(20, 0, 16, 10),
          child: Text(user!.username, style: textStyles.titleSmall ),
        ),

        const NavigationDrawerDestination(
          icon: Icon( Icons.home_outlined ), 
          label: Text( 'Home' ),
        ),


        const Padding(
          padding: EdgeInsets.fromLTRB(28, 10, 16, 1),
          child: Text('Nuevo'),
        ),
        const Padding(
          padding: EdgeInsets.fromLTRB(28, 1, 28, 1),
          child: Divider(),
        ),
        
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20),
          child: BotonPrimario(
            icon: const Icon(Icons.logout, color: Colors.white),
            label: 'Cerrar sesión',
            onPressed: () {
              ref.read(authProvider.notifier).logout();
            }
          ),
        ),

      ]
    );
  }
}