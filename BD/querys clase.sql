select * from actor;
select * from actor where actor_id = 25;
select * from actor ac
	INNER JOIN film_actor fa on ac.actor_id = fa.actor_id
    where ac.actor_id = 25;
-- comentario NOMBRE cambiado = KEVIN BLOOM id 25
update actor set first_name  = "JEFERSON" where actor_id = 25;

select * from actor ac
	INNER JOIN film_actor fa on ac.actor_id = fa.actor_id
    where ac.actor_id = 25
    and (fa.film_id between '10' and '400')
    LIMIT 50;
select * from city where exists 
(select * from country where country.country_id = city.country_id and country.country  like 'An%');
select * from sakila.language where name like 'E%'; 
select * from actor
	where actor_id In (select actor_id from film_actor where actor_id > 100);
    

select film_actor.film_id ,
(select actor_id from actor where actor.actor_id = film_actor.actor_id) as actorId,
film.description,
film.language_id,
language.name
 from film_actor 
Inner join film On film.film_id = film_actor.film_id
join language On language.language_id = film.language_id
 where film_actor.actor_id > 100;
 create table  respaldo_actor(
	actor_id integer primary key auto_increment,
    first_name varchar(45),
    last_name varchar(45),
    last_update timestamp,
    userbd varchar(50)
 );
 create trigger actor_ai
 after insert on actor
 for each row
 insert into respaldo_actor(actor_id,first_name,last_name,last_update,userbd)
 value(new.actor_id,new.first_name,new.last_name,new.last_update,current_user());
 insert into actor (first_name,last_name,last_update)
 value("jeferson","piñeros", now());
 
 select * from respaldo_actor;
 