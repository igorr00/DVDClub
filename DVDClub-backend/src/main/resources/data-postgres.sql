insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_jmbg, user_phone, user_gender, user_type, dtype, enabled) values (default, 'Admin', 'Adminic', 'admin@gmail.com', 'asd', '1', '12345', 0, 0, 'UserAdmin', true);
insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_jmbg, user_phone, user_gender, user_type, dtype, enabled) values (default, 'Sale Menadzer', 'Prvi', 'salesmenprvi@gmail.com', 'asd', '2', '12345', 0, 2, 'UserSalesManager', true);
insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_jmbg, user_phone, user_gender, user_type, dtype, enabled) values (default, 'Sale Menadzer', 'Drugi', 'salesmendrugi@gmail.com', 'asd', '3', '12345', 0, 2, 'UserSalesManager', true);

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
insert into public.genre (genre_id, genre_name) values (default, 'Animation');
insert into public.genre (genre_id, genre_name) values (default, 'Biography');
insert into public.genre (genre_id, genre_name) values (default, 'Comedy');
insert into public.genre (genre_id, genre_name) values (default, 'Crime');
insert into public.genre (genre_id, genre_name) values (default, 'Documentary');
insert into public.genre (genre_id, genre_name) values (default, 'Drama');
insert into public.genre (genre_id, genre_name) values (default, 'Family');
insert into public.genre (genre_id, genre_name) values (default, 'Fantasy');
insert into public.genre (genre_id, genre_name) values (default, 'Film-Noir');
insert into public.genre (genre_id, genre_name) values (default, 'History');
insert into public.genre (genre_id, genre_name) values (default, 'Horror');
insert into public.genre (genre_id, genre_name) values (default, 'Music');
insert into public.genre (genre_id, genre_name) values (default, 'Musical');
insert into public.genre (genre_id, genre_name) values (default, 'Mystery');
insert into public.genre (genre_id, genre_name) values (default, 'Romance');
insert into public.genre (genre_id, genre_name) values (default, 'Sci-Fi');
insert into public.genre (genre_id, genre_name) values (default, 'Sport');
insert into public.genre (genre_id, genre_name) values (default, 'Thriller');
insert into public.genre (genre_id, genre_name) values (default, 'War');
insert into public.genre (genre_id, genre_name) values (default, 'Western');


insert into public.director (director_id, director_name, director_surname, director_age, country_country_id) values (default, 'Denis', 'Villeneuve', 56, 4);

insert into public.actor (actor_id, actor_name, actor_surname, actor_age, country_country_id) values (default, 'Timothee', 'Chalamet', 28, 1);
insert into public.actor (actor_id, actor_name, actor_surname, actor_age, country_country_id) values (default, 'Rebecca', 'Ferguson', 40, 5);
insert into public.actor (actor_id, actor_name, actor_surname, actor_age, country_country_id) values (default, 'Oscar', 'Isaac', 45, 6);

insert into public.film (film_id, film_name, film_year, country_country_id, film_studio_film_studio_id, director_director_id, film_image) values (default, 'Dune', 2021, 1, 2, 1, 'https://musicart.xboxlive.com/7/f3f05100-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080');

insert into public.film_genre (film_id, genre_id) values (1, 1), (1,2), (1,3), (1,4);

insert into public.film_actor (film_id, actor_id) values (1, 1), (1,2), (1,3);

insert into public.city (city_id, city_name, country_country_id) values (default, 'Novi Sad', 3);
insert into public.city (city_id, city_name, country_country_id) values (default, 'Beograd', 3);

insert into public.marketplace (marketplace_id, marketplace_name, marketplace_street, marketplace_number, city_city_id, manager_user_id) values (default, 'Marketplace 021', 'Bulevar Oslobodjenja', '44', 1, 2);

insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id) values (default, '1080p Blu-Ray', 3000, 1000, 1);
insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id) values (default, '1080p Blu-Ray', 3000, 1000, 1);
insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id) values (default, '720p Blu-Ray', 1500, 500, 1);
insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id) values (default, '4K Blu-Ray', 5000, 2000, 1);

insert into public.marketplace_dvd (marketplace_id, dvd_id) values (1,1), (1,2), (1,3), (1,4);
