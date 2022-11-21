delete
from taco
where id > 0;
delete
from `order`
where id > 0;
delete
from user
where id > 0;
delete
from ingredient
where name is not null;
delete
from role
where id > 0;

# INGREDIENTS
insert into ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP'),
('COTO', 'Corn Tortilla', 'WRAP'),
('GRBF', 'Ground Beef', 'PROTEIN'),
('CARN', 'Carnitas', 'PROTEIN'),
('TMTO', 'Diced Tomatoes', 'VEGGIES'),
('LETC', 'Lettuce', 'VEGGIES'),
('CHED', 'Cheddar', 'CHEESE'),
('JACK', 'Monterrey Jack', 'CHEESE'),
('SLSA', 'Salsa', 'SAUCE'),
('SRCR', 'Sour Cream', 'SAUCE');

# USERS
insert into user(id, username, password, fullname, street, city, state, zip, phone_number)
values ( 1, 'user', '$2a$12$wjlGhcUkxA3rTL1L589uEeFpzZ3u0Zl.NuO5QcncvZ4JMADHBn/ja'
       , 'Eugene Kulik', 'Gorbatogo', 'Volkovysk', 'Grodnenskay', '231900', '+375297520169'),
       ( 2, 'user2', '$2a$12$wjlGhcUkxA3rTL1L589uEeFpzZ3u0Zl.NuO5QcncvZ4JMADHBn/ja'
       , 'Alex Semenchik', 'Napoleona', 'Minsk', 'Minskay', '222222', '+375294758734'),
       ( 3, 'user3', '$2a$12$wjlGhcUkxA3rTL1L589uEeFpzZ3u0Zl.NuO5QcncvZ4JMADHBn/ja'
       , 'Misha Koleda', 'Mira', 'Grodno', 'Grodnenskay', '231884', '+375295454545'),
       ( 4, 'user4', '$2a$12$wjlGhcUkxA3rTL1L589uEeFpzZ3u0Zl.NuO5QcncvZ4JMADHBn/ja'
       , 'Anton Zhuk', 'Kommunalnaya', 'Volkovysk', 'Grodnenskay', '231900', '+3752937438744');

# ROLES
insert into role (id, name)
values (1, 'ADMIN'),
       (2, 'USER');

# USER_ROLE
insert into user_role(user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 2),
       (4, 2);

# TACOS
insert into taco(id, name, created_at)
VALUES (1, 'incredible', '2022-08-15 08:00:00');

# TACO_INGREDIENTS

insert into taco_ingredients(taco_id, ingredients_id)
VALUES (1, 'FLTO'),
       (1, 'CHED'),
       (1, 'SLSA');

insert into `order`(id, user_id, placed_at)
VALUES (1,2,'2022-10-02 08:00:00'),
       (2,3,'2022-10-02 08:00:00'),
       (3,4,'2022-10-02 08:00:00');

insert into order_tacos(order_id, tacos_id)
values (1,1),
       (2,1),
       (3,1),
       (3,1);