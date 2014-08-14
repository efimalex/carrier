insert into bus_brand_spr(id, name) values(1, 'ГАЗ');
insert into bus_brand_spr(id, name) values(2, 'HYUNDAI');
insert into bus_brand_spr(id, name) values(3, 'MERSEDES');

insert into "public".bus_model_spr(id, name, bus_brand_id) values(1, 'Газель 21254', 1);
insert into "public".bus_model_spr(id, name, bus_brand_id) values(2, 'Газель 99999', 1);
insert into "public".bus_model_spr(id, name, bus_brand_id) values(3, 'Газель БИЗНЕС', 1);

insert into "public".bus_model_spr(id, name, bus_brand_id) values(4, 'Solaris', 2);

insert into "public".bus_model_spr(id, name, bus_brand_id) values(5, 'S600', 3);
insert into "public".bus_model_spr(id, name, bus_brand_id) values(6, 'S500', 3);
insert into "public".bus_model_spr(id, name, bus_brand_id) values(7, 'GLK', 3);