DELIMITER $
create procedure ejercicioClase(
inout contador int
)
begin
    set contador = contador + 1;
end $
DELIMITER ;
set @contador = 1;
select @contador;
call ejercicioClase(@contador);
drop procedure ejercicioClase

delimiter $
create procedure actoresConpeliculas(inout idActor int)
begin
    set idActor =  (select count(fl.film_id) from actor ac
		join film_actor fa on ac.actor_id = fa.actor_id
        join film fl on fl.film_id = fa.film_id
        where ac.actor_id = idActor);
end $
delimiter ;

set @idActor = 20;
select @idActor;
call actoresConpeliculas(@idActor);