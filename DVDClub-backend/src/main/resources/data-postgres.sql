insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_phone, user_gender, user_type, enabled) values (default, 'Admin', 'Adminic', 'admin@gmail.com', 'asd', '12345', 0, 0, true);
insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_phone, user_gender, user_type, enabled) values (default, 'Pera', 'Peric', 'pera@gmail.com', 'asd','12345', 0, 2, true);
insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_phone, user_gender, user_type, enabled) values (default, 'Mika', 'Mikic', 'mika@gmail.com', 'asd','12345', 0, 2, true);
insert into public.user (user_id, user_name, user_surname, user_email, user_password, user_phone, user_gender, user_type, enabled) values (default, 'Zika', 'Zikic', 'zika@gmail.com', 'asd','12345', 0, 3, true);

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

insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id, available) values (default, '1080p Blu-Ray', 3000, 1000, 1, true);
insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id, available) values (default, '1080p Blu-Ray', 3000, 1000, 1, false);
insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id, available) values (default, '720p Blu-Ray', 1500, 500, 1, false);
insert into public.dvd (dvd_id, dvd_format, dvd_price_buy, dvd_price_rent, film_film_id, available) values (default, '4K Blu-Ray', 5000, 2000, 1, true);

insert into public.special_offer (special_offer_id, special_offer_name, special_offer_price, special_offer_start_date, special_offer_end_date, available) values (default, 'Dune (2021) 1080p + 720p combo', 3500, '2024-6-1', '2024-8-1', true);
insert into public.special_offer_dvd (special_offer_id, dvd_id) values (1,2), (1,3);

insert into public.marketplace_dvd (marketplace_id, dvd_id) values (1,1), (1,2), (1,3), (1,4);
insert into public.marketplace_special_offer (marketplace_id, special_offer_id) values (1,1);

insert into public.news (news_id, news_date, news_title, news_text) values (default, '2024-6-2', 'New marketplace opened', 'A brand new marketplace has been opened in the city of Novi Sad. It is located in Bulevar Oslobodjenja 44. Check out the dvds we have for sale. Newest hits, old classics and many many more.')
