# mvc
Desarrollado: SpringMvc,Hibernate,Oracle,NetBeans, jQuery, Ajax,Jsp


--llamada de logueo

create or replace function login (x in varchar2, y in varchar2)
return number
as
  match_count number;
begin
  select count(*)
    into match_count
    from bankcustomer
    where usuario=x
    and contraseña=y;
  if match_count = 0 then
    return 0;
  elsif match_count = 1 then
    return 1;
  end if;
end;





---Crear una secuencia

CREATE SEQUENCE Secuencia_clientes
INCREMENT BY 1
START WITH 1
NOMINVALUE
NOMAXVALUE;


create or replace TRIGGER TRG
BEFORE INSERT ON clientes
REFERENCING NEW AS NEW FOR EACH ROW
DECLARE valorSecuencia int := 0;
BEGIN
SELECT Secuencia_clientes.NEXTVAL INTO valorSecuencia FROM DUAL;
:NEW.carnet := valorSecuencia;
END;
