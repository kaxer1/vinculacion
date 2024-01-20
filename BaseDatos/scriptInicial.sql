INSERT INTO public.catalogo (idcatalogo, activo, nombre) VALUES (1, 1, 'IDENTIFICACIÓN');
INSERT INTO public.catalogo (idcatalogo, activo, nombre) VALUES (2, 1, 'RASAS ANIMALES');

INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (1, 'R', 1, 'RUC');
INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (1, 'C', 1, 'CEDULA');
INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (1, 'P', 1, 'PASAPORTE');
INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (2, 'P01', 1, 'PITWEILER');
INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (2, 'H01', 1, 'HUSKY SIBERIANO');
INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (2, 'K01', 1, 'KAI KEN');
INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (2, 'S01', 1, 'SABUESO POLACO');
INSERT INTO public.catalogodetalle (idcatalogo, iddetalle, activo, nombre) VALUES (2, 'S02', 1, 'SABUESO ESPAÑOL');

INSERT INTO public.seguridadpolitica (idpolitica, especiales, intentos, longitud, mayusculas, minusculas, numeros, tiemporegeraciontoken) VALUES (1, 2, 3, 10, 2, 2, 2, 30);

INSERT INTO public.rol (idrol, activo, nombre, idpolitica) VALUES (1, 1, 'SUPER ADMINISTRADOR', 1);
INSERT INTO public.rol (idrol, activo, nombre, idpolitica) VALUES (2, 1, 'ADMINISTRADOR', 1);
INSERT INTO public.rol (idrol, activo, nombre, idpolitica) VALUES (3, 1, 'PASEADORES', 1);
INSERT INTO public.rol (idrol, activo, nombre, idpolitica) VALUES (4, 1, 'CLIENTES', 1);

INSERT INTO public.personadetalle (idpersona, apellidos, celular, email, fechaingreso, fechamodificacion, identificacion, idusuarioing, idusuariomod, nombres, iddetalleidentificacion, idcatalogoidentificacion) VALUES (1, 'FUNDACIÓN', null, 'arnuev@gmail.com', null, null, '0123456789001', null, null, 'ADNUV', 1, 'R');
INSERT INTO public.personadetalle (idpersona, apellidos, celular, email, fechaingreso, fechamodificacion, identificacion, idusuarioing, idusuariomod, nombres, iddetalleidentificacion, idcatalogoidentificacion) VALUES (2, 'ADMINISTRADOR', null, 'administrador@gmail.com', null, null, '0123456788001', null, null, 'ADMINISTRADOR', 1, 'R');
INSERT INTO public.personadetalle (idpersona, apellidos, celular, email, fechaingreso, fechamodificacion, identificacion, idusuarioing, idusuariomod, nombres, iddetalleidentificacion, idcatalogoidentificacion) VALUES (3, 'CURAY', null, 'kevincuray@gmail.com', null, null, '0503908888', null, null, 'KEVIN', 1, 'C');
INSERT INTO public.personadetalle (idpersona, apellidos, celular, email, fechaingreso, fechamodificacion, identificacion, idusuarioing, idusuariomod, nombres, iddetalleidentificacion, idcatalogoidentificacion) VALUES (4, 'PASEADOR', null, 'paseador@gmail.com', null, null, '0503908889', null, null, 'PASEADOR', 1, 'C');

/** password: Arnuv12345 **/
INSERT INTO public.usuariodetalle (idusuario, cambiopassword, estado, fechaaprobacion, fechaingreso, fechamodificacion, idusuarioaprobacion, idusuarioing, idusuariomod, observacion, password, username, idpersona) VALUES (1, 0, 1, '2024-01-19', '2024-01-19', null, null, null, null, 'POR DEFECTO', '158dbeac0cc77478f09794f17cd0fa6f1c9ba784653707e085060b9e6dc69a38', 'SUPERADMIN', 1);
INSERT INTO public.usuariodetalle (idusuario, cambiopassword, estado, fechaaprobacion, fechaingreso, fechamodificacion, idusuarioaprobacion, idusuarioing, idusuariomod, observacion, password, username, idpersona) VALUES (2, 0, 1, '2024-01-19', '2024-01-19', null, null, null, null, 'POR DEFECTO', '158dbeac0cc77478f09794f17cd0fa6f1c9ba784653707e085060b9e6dc69a38', 'ADMIN', 2);
INSERT INTO public.usuariodetalle (idusuario, cambiopassword, estado, fechaaprobacion, fechaingreso, fechamodificacion, idusuarioaprobacion, idusuarioing, idusuariomod, observacion, password, username, idpersona) VALUES (3, 0, 1, '2024-01-19', '2024-01-19', null, null, null, null, 'POR DEFECTO', '158dbeac0cc77478f09794f17cd0fa6f1c9ba784653707e085060b9e6dc69a38', 'KEVINUSER', 3);
INSERT INTO public.usuariodetalle (idusuario, cambiopassword, estado, fechaaprobacion, fechaingreso, fechamodificacion, idusuarioaprobacion, idusuarioing, idusuariomod, observacion, password, username, idpersona) VALUES (4, 0, 1, '2024-01-19', '2024-01-19', null, null, null, null, 'POR DEFECTO', '158dbeac0cc77478f09794f17cd0fa6f1c9ba784653707e085060b9e6dc69a38', 'PASEADOR1', 4);

INSERT INTO public.usuariorol (fechaingreso, fechamodificacion, idususarioing, idususariomod, idrol, idusuario) VALUES ('2024-01-19', null, 'SUPERADMIN', null, 1, 1);
INSERT INTO public.usuariorol (fechaingreso, fechamodificacion, idususarioing, idususariomod, idrol, idusuario) VALUES ('2024-01-19', null, 'SUPERADMIN', null, 2, 2);
INSERT INTO public.usuariorol (fechaingreso, fechamodificacion, idususarioing, idususariomod, idrol, idusuario) VALUES ('2024-01-19', null, 'SUPERADMIN', null, 3, 4);
INSERT INTO public.usuariorol (fechaingreso, fechamodificacion, idususarioing, idususariomod, idrol, idusuario) VALUES ('2024-01-19', null, 'SUPERADMIN', null, 4, 3);

INSERT INTO public.modulos (idmodulo, activo, nombre) VALUES (1, 1, 'AUTENTICACIÓN');
INSERT INTO public.modulos (idmodulo, activo, nombre) VALUES (2, 1, 'PERSONAS');
INSERT INTO public.modulos (idmodulo, activo, nombre) VALUES (3, 1, 'GENERALES');

INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (1, 1, 'LOGIN', '/login');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (3, 1, 'CAMBIAR CONTRASEÑA', '/cambiarpassword');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (2, 1, 'CHECK MENU', null);
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (4, 1, 'REGISTRAR USUARIO', '/registrar-usuario');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (5, 1, 'REGISTRAR ROL', '/registrar-rol');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (6, 1, 'REGISTRAR POLITICA SEGURIDAD', '/registrar-seguridad-politica');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (7, 1, 'REGISTRAR USUARIO ROL', '/registrar-usurio-rol');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (8, 1, 'SESIONES ACTIVAS', '/sesiones-activas');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (2, 2, 'REGISTRAR CLIENTES', '/registrar-persona');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (1, 2, 'REGISTRAR PASEADORES', '/registrar-persona');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (1, 3, 'REGISTRAR RECURSOS', '/registrar-recursos');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (2, 3, 'REGISTRAR CATALOGO', '/registrar-catalogo');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (3, 3, 'REGISTRAR CATALOGO DETALLE', '/registrar-catalogo-detalle');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (4, 3, 'REGISTRAR MODULOS', '/registrar-modulos');
INSERT INTO public.recursos (idrecurso, idmodulo, nombre, ruta) VALUES (5, 3, 'REGISTRAR MENU', '/registrar-menu');

INSERT INTO public.opcionespermisos (idrol, idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idmodulo, idrecurso) VALUES (1, 2, 1, 1, 1, 1, 1, 1, null, 1, 4);
INSERT INTO public.opcionespermisos (idrol, idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idmodulo, idrecurso) VALUES (1, 5, 1, 1, 1, 1, null, 1, 'SEGURIDAD', null, null);
INSERT INTO public.opcionespermisos (idrol, idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idmodulo, idrecurso) VALUES (1, 1, 1, 1, 1, 1, null, 1, 'USUARIOS', null, null);
INSERT INTO public.opcionespermisos (idrol, idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idmodulo, idrecurso) VALUES (1, 4, 1, 1, 1, 1, 5, 1, null, 1, 6);
INSERT INTO public.opcionespermisos (idrol, idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idmodulo, idrecurso) VALUES (1, 3, 1, 1, 1, 1, 5, 1, null, 1, 5);
INSERT INTO public.opcionespermisos (idrol, idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idmodulo, idrecurso) VALUES (1, 6, 1, 1, 1, 1, 1, 1, null, 1, 7);
INSERT INTO public.opcionespermisos (idrol, idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idmodulo, idrecurso) VALUES (1, 7, 1, 1, 1, 1, 5, 1, null, 1, 8);


ALTER SEQUENCE catalogo_idcatalogo_seq RESTART WITH 3;
ALTER SEQUENCE modulos_idmodulo_seq RESTART WITH 4;
ALTER SEQUENCE rol_idrol_seq RESTART WITH 5;
ALTER SEQUENCE seguridadpolitica_idpolitica_seq RESTART WITH 2;
ALTER SEQUENCE usuariodetalle_idusuario_seq RESTART WITH 5;
ALTER SEQUENCE personadetalle_idpersona_seq RESTART WITH 5;