CREATE user 'prueba1'@'localhost' identified by '123456';
/*Asignar permiso*/
/* grant [permsio] on [nombre de mi base de datos] [nombre tabla] 'jeferson'@'localhost';*/
GRANT ALL privileges ON *.* TO 'prueba1'@'localhost';
show grants for 'prueba1'@'localhost'; 

Create user 'prueba2'@'localhost' identified by '123456';
grant ALL privileges ON persona.usuario to 'prueba2'@'localhost';

revoke all privileges on *.* to 'prueba1'@'localhost';

revoke insert,update,select  ON persona.usuario  from 'prueba2'@'localhost';
show grants for 'prueba2'@'localhost';