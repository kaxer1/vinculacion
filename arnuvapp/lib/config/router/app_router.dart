import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import 'package:arnuvapp/config/router/const_routes.dart';
import 'package:arnuvapp/config/router/export_modulos.dart';

import 'app_router_notifier.dart';

final goRouterProvider = Provider((ref) {

  final goRouterNotifier = ref.read(goRouterNotifierProvider);

  return GoRouter(
    initialLocation: ConstRoutes.SPLASH,
    refreshListenable: goRouterNotifier,
    routes: [
      ///* Primera pantalla
      GoRoute(
        path: ConstRoutes.SPLASH,
        builder: (context, state) => const CheckAuthStatusScreen(),
      ),

      ///* Autenticacion Routes
      GoRoute(
        path: ConstRoutes.LOGIN,
        builder: (context, state) => const LoginScreen(),
      ),

      ///* Navegacion Routes
      GoRoute(
        path: ConstRoutes.NAVEGACION,
        builder: (context, state) => const NavegacionScreen(),
      ),
      GoRoute(
        path: ConstRoutes.IDIOMA,
        builder: (context, state) => const IdiomaScreen(),
      ),
      
      // GoRoute(
      //   path: '/',
      //   builder: (context, state) => const ProductsScreen(),
      // ),
      
      ///* Product Routes
      // GoRoute(
      //   path: '/',
      //   builder: (context, state) => const ProductsScreen(),
      // ),
      // GoRoute(
      //   path: '/product/:id',
      //   builder: (context, state) => ProductScreen(
      //     productId: state.params['id'] ?? 'no-id',
      //   ),
      // ),
    ],

    redirect: (context, state) {
      
      final isGoingTo = state.subloc;
      final authStatus = goRouterNotifier.authStatus;

      if ( isGoingTo == ConstRoutes.SPLASH && authStatus == AuthStatus.checking ) return null;

      if ( authStatus == AuthStatus.notAuthenticated ) {
        if ( isGoingTo == ConstRoutes.LOGIN ) return null;

        return ConstRoutes.LOGIN;
      }

      if ( authStatus == AuthStatus.authenticated ) {
        if ( isGoingTo == ConstRoutes.LOGIN || isGoingTo == ConstRoutes.SPLASH ){
          return ConstRoutes.NAVEGACION;
        }
      }


      return null;
    },
  );
});
