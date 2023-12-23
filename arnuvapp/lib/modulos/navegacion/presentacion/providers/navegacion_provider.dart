import 'package:flutter/widgets.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

//! 3 - StateNotifierProvider - consume afuera
final navegacionProvider = StateNotifierProvider.autoDispose<NavegacionNotifier,NavegacionState>((ref) {

  return NavegacionNotifier();
});


//! 2 - Como implementamos un notifier
class NavegacionNotifier extends StateNotifier<NavegacionState> {

  NavegacionNotifier(): super( NavegacionState() );

  void onSeleccionaMenu(int value) {
    state = state.copyWith(
      menuIndex: value
    );
  }

}


//! 1 - State del provider
class NavegacionState {

  final int menuIndex;
  List<BottomNavigationBarItem> items = [];

  NavegacionState({
    this.menuIndex = 0,
    this.items = const [
      BottomNavigationBarItem(
        icon: ImageIcon( AssetImage('assets/footer icons/ic_banking.png') ),
        activeIcon: ImageIcon( AssetImage('assets/footer icons/ic_banking_act.png') ),
        label: 'Banco'
        // label: localizations.translate('banco'),
      ),
      // BottomNavigationBarItem(
      //   icon: ImageIcon( AssetImage('assets/footer icons/ic_transaction.png') ),
      //   activeIcon: ImageIcon( AssetImage('assets/footer icons/ic_transaction_act.png') ),
      //   label: localizations.translate('transacciones'),
      // ),
      BottomNavigationBarItem(
        icon: ImageIcon( AssetImage('assets/footer icons/ic_accounts.png') ),
        activeIcon: ImageIcon( AssetImage('assets/footer icons/ic_accounts_act.png') ),
        label: 'Perfil'
        // label: localizations.translate('perfil'),
      ),
    ]
  });

  NavegacionState copyWith({
    int? menuIndex,
    List<BottomNavigationBarItem>? items,
  }) => NavegacionState(
    menuIndex: menuIndex ?? this.menuIndex,
    items: items ?? this.items,
  );

  @override
  String toString() {
    return '''
  NavegacionState:
    menuIndex: $menuIndex
    items: $items
''';
  }
}
