alter table users
add column location_id integer references locations(id);