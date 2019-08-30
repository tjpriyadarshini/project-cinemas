create table movie_theatres(
movie_id integer references movies(id),
theatre_id integer references theatres(id),
primary key (movie_id,theatre_id));
