insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_jmbg, user_phone, user_gender, user_type) values (default, 'Admin', 'Adminic', 'admin@gmail.com', 'asd', '123', '12345', 0, 0);

insert into public.country (country_id, country_name) values (default, 'USA');
insert into public.country (country_id, country_name) values (default, 'Great Britain');
insert into public.country (country_id, country_name) values (default, 'Serbia');
insert into public.country (country_id, country_name) values (default, 'France');
insert into public.country (country_id, country_name) values (default, 'Sweden');
insert into public.country (country_id, country_name) values (default, 'Guatemala');

insert into public.film_studio (film_studio_id, film_studio_name, country_country_id) values (default, 'Walt Disney Studios Motion Pictures', 1);
insert into public.film_studio (film_studio_id, film_studio_name, country_country_id) values (default, 'Warner Bros Pictures', 1);

insert into public.genre (genre_id, genre_name) values (default, 'Action');
insert into public.genre (genre_id, genre_name) values (default, 'Adventure');
insert into public.genre (genre_id, genre_name) values (default, 'Drama');
insert into public.genre (genre_id, genre_name) values (default, 'Sci-Fi');

insert into public.director (director_id, director_name, director_surname, director_age, country_country_id) values (default, 'Denis', 'Villeneuve', 56, 4);

insert into public.actor (actor_id, actor_name, actor_surname, actor_age, country_country_id) values (default, 'Timothee', 'Chalamet', 28, 1);
insert into public.actor (actor_id, actor_name, actor_surname, actor_age, country_country_id) values (default, 'Rebecca', 'Ferguson', 40, 5);
insert into public.actor (actor_id, actor_name, actor_surname, actor_age, country_country_id) values (default, 'Oscar', 'Isaac', 45, 6);

insert into public.film (film_id, film_name, film_year, country_country_id, film_studio_film_studio_id, director_director_id) values (default, 'Dune', 2021, 1, 2, 1);

insert into public.film_genre (film_id, genre_id) values (1, 1), (1,2), (1,3), (1,4);

insert into public.film_actor (film_id, actor_id) values (1, 1), (1,2), (1,3);

