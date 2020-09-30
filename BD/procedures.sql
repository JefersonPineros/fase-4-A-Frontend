delimiter $
create procedure proceso()
begin
declare x int;
create table numeros(numero int);
set x = 1;
while x <= 10 do
	insert into numeros()
    value(x);
	set x = x + 1;
end while;
end $
delimiter ;

call proceso();
drop procedure proceso;
drop table numeros;
select * from numeros;


DELIMITER $$
CREATE PROCEDURE simple_loop ( )
BEGIN
  DECLARE counter BIGINT DEFAULT 0;
 
  my_loop: LOOP
    SET counter=counter+1;
    IF counter >= 41 THEN
      LEAVE my_loop;
    END IF;

    SELECT counter;

  END LOOP my_loop;
END$$
DELIMITER ;
drop procedure simple_loop;
CALL simple_loop();
