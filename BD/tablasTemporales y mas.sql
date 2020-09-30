Drop table actoresFilm;
create temporary table actoresFilm(
	actor_id int,
    first_name varchar(50),
    film_id int,
    title varchar(100),
    lenguaje int 
);

insert into actoresFilm(actor_id,first_name, film_id,title,lenguaje)
values(1,'Daniel',2,'Mil maravillas,',1);
select * from actoresFilm;


create temporary table actoresFilm 
select ac.actor_id,ac.first_name,f.film_id,f.title,f.language_id, lan.name from actor ac
	join film_actor fc On ac.actor_id = fc.actor_id
    join film f ON fc.film_id = f.film_id
    join language lan ON f.language_id = lan.language_id;
    
    select * from actoresFilm  order by actoresFilm.actor_id  limit 5000;
    
    -- vistas
    
    create view actores as 
		select	actor_id,first_name from actor;
	select * from actores; 
    
    -- sub consultas
    
    select  
    *,(
    select film_id 
    from film_actor 
	where film_actor.actor_id = actor.actor_id
    ) 
	as filmuh 
    from actor;
  
    