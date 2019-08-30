create table movies (
id serial primary key,
movie_name varchar,
sound_track varchar,
release_date DATE NOT NULL DEFAULT CURRENT_DATE);
