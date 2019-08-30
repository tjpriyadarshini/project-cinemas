create table theatres(
id serial primary key,
theatre_name varchar,
location_id integer references locations(id));