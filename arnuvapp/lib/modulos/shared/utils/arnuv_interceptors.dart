import 'package:dio/dio.dart';
import 'package:arnuvapp/modulos/shared/infrastructure/services/key_value_storage_service_impl.dart';

class ArnuvInterceptors extends Interceptor {
  final keyValueStorageService = KeyValueStorageServiceImpl();

  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) async {
    print('REQUEST[${options.method}] => PATH: ${options.path}');
    final token = await keyValueStorageService.getValue<String>('token');
    if (token != null) {
      options.headers.addAll({'Authorization': 'Bearer $token'});
    }
    
    super.onRequest(options, handler);
  }

  @override
  void onResponse(Response response, ResponseInterceptorHandler handler) async {
    print('RESPONSE[${response.statusCode}] => PATH: ${response.requestOptions.path}');

    if(response.headers['token'] != null) {
      String token = response.headers.value('token')!;
      await keyValueStorageService.setKeyValue<String>('token', token);
    }
    super.onResponse(response, handler);
  }

  @override
  Future onError(DioException err, ErrorInterceptorHandler handler) async {
    print('ERROR[${err.response?.statusCode}] => PATH: ${err.requestOptions.path}');
    if( err.response?.statusCode == 401 || err.response?.statusCode == 403){
      await keyValueStorageService.removeKey('token');
    }
    super.onError(err, handler);
  }
}