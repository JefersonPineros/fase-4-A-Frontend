INSERT INTO skillexbd.usuario VALUES(null,"Wainer","Gaitan","wgaitan@gmail.com","123456","","2020-09-28 00:00","2020-09-18 00:00","","45565546",1,1);
insert into skillexbd.tipousuario values (null, 1, 'Administrador'),(null, 2, 'Bartender'),(null, 3, 'Cliente');
insert into inventario values(null,'Skillex', '1000');
INSERT INTO `skillexbd`.`estado_pedido` (`id_Estado_pedido`, `State_id`, `descripcion`) VALUES ('1', '1', 'Entregado');
INSERT INTO `skillexbd`.`estado_pedido` (`id_Estado_pedido`, `State_id`, `descripcion`) VALUES ('2', '2', 'Procesado');
INSERT INTO `skillexbd`.`estado_pedido` (`id_Estado_pedido`, `State_id`, `descripcion`) VALUES ('3', '3', 'Recibido');

INSERT INTO skillexbd.categoria_producto (id_categoria_producto, tipo_categoria) VALUES (1, 'Cerveza');
INSERT INTO skillexbd.categoria_producto (id_categoria_producto, tipo_categoria) VALUES (2, 'Aguardiente');
INSERT INTO skillexbd.categoria_producto (id_categoria_producto, tipo_categoria) VALUES (4, 'Whisky');
INSERT INTO skillexbd.categoria_producto (id_categoria_producto, tipo_categoria) VALUES (3, 'Aperitivos');
INSERT INTO skillexbd.categoria_producto (id_categoria_producto, tipo_categoria) VALUES (5, 'Cócteles');

INSERT INTO skillexbd.productos VALUES (null,'Poker', 'Beer Poker', 'CE001', 'Activo', 75, '2020-01-03', 1, 1);
INSERT INTO skillexbd.productos VALUES (null,'Aguila', 'Beer Aguila', 'CE002', 'Activo', 36, '2020-02-03', 1, 1);
INSERT INTO skillexbd.productos VALUES (null,'Antioqueño', 'Antioqueño', 'A001', 'Activo', 58, '2020-02-01', 1, 2);
INSERT INTO skillexbd.productos VALUES (null,'Nectar', 'Nectar', 'A002', 'Activo', 45, '2020-07-05', 1, 2);
INSERT INTO skillexbd.productos VALUES (null,'Jhon Thomas', 'blabla', 'W001', 'Activo', 47, '2020-06-04', 1, 4);
INSERT INTO skillexbd.productos VALUES (null,'Old Park', 'Old Park', 'W002', 'Activo', 23, '2020-09-03', 1, 4);
INSERT INTO skillexbd.productos VALUES (null,'Nuggets', 'Nuggets', 'A001', 'Activo', 14, '2020-07-08', 1, 3);
INSERT INTO skillexbd.productos VALUES (null,'Pinchos', 'Pinchos', 'A002', 'Activo', 16, '2020-01-02', 1, 3);
INSERT INTO skillexbd.productos VALUES (null,'Margarita', 'Maragret', 'C001', 'Activo', 85, '2019-02-05', 1, 5);
INSERT INTO skillexbd.productos VALUES (null,'Mojito', 'Mojito', 'C002', 'Activo', 36, '2019-05-03', 1, 5);

INSERT INTO skillexbd.detalle_productos VALUES (null, 2000, 2320, 'Cuyo componente de almidón será modificado para ser luego fermentado en agua y aromatizado con lúpulo.', 'Cuyo componente de almidón será modificado para ser luego fermentado en agua y aromatizado con lúpulo.',  1,''),
 (null, 30000, 34800, 'El aguardiente es una bebida alcohólica destiladadestilada]] de un fermentado alcohólico.', 'El aguardiente es una bebida alcohólica destiladadestilada]] de un fermentado alcohólico.',  2,''),
 (null, 35000, 40600, 'Existe gran variedad de sustancias orgánicas agrícolas cuya pasta o zumo fermentado es usado para su extracción, incluyendo frutas, cereales, hortalizas y granos.', 'Existe gran variedad de sustancias orgánicas agrícolas cuya pasta o zumo fermentado es usado para su extracción, incluyendo frutas, cereales, hortalizas y granos.',  3,''),
 (null, 85000, 98600, 'El whisky (del gaélico escocés: uisge-beatha), whiskey (del irlandés: uisce beatha o fuisce), wiski​ o güisqui​ es una bebida alcohólica obtenida por la destilación de la malta fermentada', 'El whisky (del gaélico escocés: uisge-beatha), whiskey (del irlandés: uisce beatha o fuisce), wiski​ o güisqui​ es una bebida alcohólica obtenida por la destilación de la malta fermentada', 4,''),
 (null, 79000, 91640, 'Whisky de cereales como cebada, trigo, centeno y maíz, y su posterior añejamiento en barriles de madera, tradicionalmente de roble blanco.', 'Whisky de cereales como cebada, trigo, centeno y maíz, y su posterior añejamiento en barriles de madera, tradicionalmente de roble blano.',  5,''),
 (null, 6000, 6960, 'Un nugget de pollo (en inglés nugget significa \'pepita\') es un alimento compuesto parcialmente de una carne de pollo finamente picada.', 'Un nugget de pollo (en inglés nugget significa \'pepita\') es un alimento compuesto parcialmente de una carne de pollo finamente picada,', 6,''),
 (null, 5000, 5800,  'Se llama pincho (pintxo en su grafía en euskera) a una pequeña rebanada de pan sobre la que se coloca una pequeña porción de comida.', 'Se llama pincho (pintxo en su grafía en euskera) a una pequeña rebanada de pan sobre la que se coloca una pequeña porción de comida.', 7,''),
 (null, 16000, 18560, 'Un cóctel (también mencionado como coctel) es una combinación de diferentes bebidas, por lo general alcohólicas.', 'Un cóctel (también mencionado como coctel) es una combinación de diferentes bebidas, por lo general alcohólicas.',  8,''),
 (null, 20000, 23200,'Licores, jugos (zumos) frutales, gaseosas (bebidas carbónicas) y diferentes bebidas espirituosas pueden formar parte de un cóctel.', 'Licores, jugos (zumos) frutales, gaseosas (bebidas carbónicas) y diferentes bebidas espirituosas pueden formar parte de un cóctel.', 9,''),
 (null, 2000, 2320, 'Cuyo componente de almidón será modificado para ser luego fermentado en agua y aromatizado con lúpulo.', 'Cuyo componente de almidón será modificado para ser luego fermentado en agua y aromatizado con lúpulo.',  10,'');