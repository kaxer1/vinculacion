import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
// import 'package:animation_wrappers/animation_wrappers.dart';
// import 'package:arnuvapp/modulos/navegacion/domain/domain.dart';
// import 'package:arnuvapp/modulos/navegacion/presentacion/providers/providers.dart';
import 'package:arnuvapp/modulos/shared/shared.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => FocusManager.instance.primaryFocus?.unfocus(),
      child: const _HomeScreen()
    );
  }
}

class _HomeScreen extends ConsumerWidget {

  const _HomeScreen();

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // final themeStyle = Theme.of(context);
    // final home = ref.watch(homeProvider);
    // final homeNotifier = ref.watch(homeProvider.notifier);
    // final localizations = AppLocalizations.of(context);
    

    return Scaffold(
      body: ListView(
        physics: const BouncingScrollPhysics(),
        children: const [
          Stack(
            children: [
              TituloBannerHome(),
            ],
          ),
        ],
      ),
    );
  }



}