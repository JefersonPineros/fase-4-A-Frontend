use productos;
create table libros(
	codigo int auto_increment primary key,
    titulo varchar(45),
    autor varchar(45),
    editorial varchar(45),
    precio bigint,
    codigoEditorial int,
    foreign key (codigoEditorial) References editorialLibros(codigoEditorial)
);
use productos;
create table editorialLibros(
	codigoEditorial int auto_increment primary key,
    nombreEditorial varchar(45)
);
insert into editorialLibros(codigoEditorial,nombreEditorial)
value(1,"la cajita de papel"),
(2,"la brujita"),
(3,"La torre"),
(4,"Le france"),
(5,"Hojitas");

insert into libros(titulo,autor,editorial,precio,codigoEditorial)
value("100 AÑOS DE SOLEDAD","GABRIEL GARCÍA MÁRQUEZ","la cajita de papel",350000,1),
("CRIMEN Y CASTIGO","FIÓDOR DOSTOYEVSKI","la brujita",190000,2),
("ORGULLO Y PREJUICIO","JANE AUSTEN","la brujita",200000,2),
("EL SEÑOR DE LOS ANILLOS","J.R.R. TOLKIEN","La torre",380000,3),
("DON QUIJOTE DE LA MANCHA","MIGUEL DE CERVANTES","La torre",250000,3),
("EL PRINCIPITO","ANTOINE DE SAINT-EXUPÉRY","Le france",35000,4),
("EL GRAN GATSBY","F. SCOTT FITZGERALD","le france",150000,4),
("CUENTOS INFANTILES","HANS CHRISTIAN ANDERSEN","Hojitas",90000,5),
("1984","GEORGE ORWELLS","Le france",120000,4),
("LA ILÍADA","HOMERO","La torre",65000,3),
("ROMANCERO GITANO","FEDERICO GARCÍA LORCA","La torre",79000,3);
select max(precio) as precioMaximo,titulo from libros;
select *,(select max(precio) from libros) - precio as diferencia 
from libros where codigo = 5;

select autor,editorial  from libros 
where codigoEditorial in (select editorialLibros.codigoEditorial  from editorialLibros where codigoEditorial =2  );
select * from editorialLibros 
where codigoEditorial in (select libros.codigoEditorial from libros)