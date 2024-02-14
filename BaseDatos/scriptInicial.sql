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

INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (1, 'LOGIN', '/login', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (3, 'CAMBIAR CONTRASEÑA', '/cambiarpassword', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (2, 'CHECK MENU', null, 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (4, 'REGISTRAR USUARIO', '/registrar-usuario', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (5, 'REGISTRAR ROL', '/registrar-rol', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (6, 'REGISTRAR POLITICA SEGURIDAD', '/registrar-seguridad-politica', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (7, 'REGISTRAR USUARIO ROL', '/registrar-usurio-rol', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (8, 'SESIONES ACTIVAS', '/sesiones-activas', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (9, 'REGISTRO UNIFICADO USUARIO', '/registro-unificado-usuario', 1);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (1, 'REGISTRAR PERSONAS', '/registrar-persona', 2);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (2, 'REGISTRAR PERSONAS DIRECCIÓN', '/registrar-persona-direccion', 2);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (1, 'REGISTRAR RECURSOS', '/registrar-recursos', 3);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (2, 'REGISTRAR CATALOGO', '/registrar-catalogo', 3);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (3, 'REGISTRAR CATALOGO DETALLE', '/registrar-catalogo-detalle', 3);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (4, 'REGISTRAR MODULOS', '/registrar-modulos', 3);
INSERT INTO public.recursos (idrecurso, nombre, ruta, idmodulo) VALUES (5, 'REGISTRAR MENU', '/registrar-menu', 3);



INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (1, 1, 1, 1, 1, null, 1, 'USUARIOS', 1, null, null);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (2, 1, 1, 1, 1, 1, 1, null, 1, 1, 4);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (3, 1, 1, 1, 1, 5, 1, null, 1, 1, 5);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (4, 1, 1, 1, 1, 5, 1, null, 1, 1, 6);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (5, 1, 1, 1, 1, null, 1, 'SEGURIDAD', 1, null, null);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (6, 1, 1, 1, 1, 1, 1, null, 1, 1, 7);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (7, 1, 1, 1, 1, 5, 1, null, 1, 1, 8);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (8, 1, 1, 1, 1, null, 1, 'PERSONAS', 1, null, null);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (9, 1, 1, 1, 1, 8, 1, null, 1, 2, 1);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (10, 1, 1, 1, 1, 8, 1, null, 1, 2, 2);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (11, 1, 1, 1, 1, null, 1, 'GENERALES', 1, null, null);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (12, 1, 1, 1, 1, 11, 1, null, 1, 3, 2);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (13, 1, 1, 1, 1, 11, 1, null, 1, 3, 3);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (14, 1, 1, 1, 1, 11, 1, null, 1, 3, 4);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (15, 1, 1, 1, 1, 11, 1, null, 1, 3, 5);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (16, 1, 1, 1, 1, 1, 1, null, 1, 1, 9);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (1, 1, 1, 1, 1, null, 1, 'USUARIOS', 2, null, null);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (2, 1, 1, 1, 1, null, 1, 'GENERALES', 2, null, null);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (3, 1, 1, 1, 0, 2, 1, null, 2, 1, 5);
INSERT INTO public.opcionespermisos (idopcion, activo, crear, editar, eliminar, idopcionpadre, mostar, nombre, idrol, idmodulo, idrecurso) VALUES (4, 1, 1, 1, 0, 1, 1, null, 2, 1, 9);



ALTER SEQUENCE catalogo_idcatalogo_seq RESTART WITH 3;
ALTER SEQUENCE modulos_idmodulo_seq RESTART WITH 4;
ALTER SEQUENCE rol_idrol_seq RESTART WITH 5;
ALTER SEQUENCE seguridadpolitica_idpolitica_seq RESTART WITH 2;
ALTER SEQUENCE usuariodetalle_idusuario_seq RESTART WITH 5;
ALTER SEQUENCE personadetalle_idpersona_seq RESTART WITH 5;