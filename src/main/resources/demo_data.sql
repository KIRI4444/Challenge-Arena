insert into users (name, username, password, goals, age, description, sex)
values ('Kirill Popov', 'kiri4444', '$2a$12$bmiTiiNi8Zy/qXRDqfLlRepWW3tDWYJVIpVS3b4fJwfGolIyxBZaC
', 'Earn money, get plane', 19, 'Playboy, Philantrop, Legend, Gand Back Programmer', 1),
       ('Dmitriy Kvitko', 'DimarsekShkere', '$2a$12$UihUIBizOlzMYJ0k9qOWkepu4ZSbBRoj2V2dcH3zi1UMmOnrhQNve
', 'Be cool programmer, smoke weed', 19, 'Gay Front Programmer', 0),
       ('Mark Granovskiy', 'MarkSisya', '$2a$12$YAcrl1yC9kkKFXJsd76c/un3YfFtWaqTlm8S3YcTjNMZoeaqwt5C6
', 'Be the best Ogetto front programmer', 19, 'Sisyan', 0);

insert into challenges (description, rules, title, type, date)
values ('Челлендж чтобы кайфовать', 'Нужно вылить на себя ведро ледяной воды', 'Ice bucket challenge', 'Одиночный',
        '26-10-2024 16:00'),
       ('Челлендж для сплочения коллектива', 'Нужно сфоткаться с коллегами', 'Групповое фото', 'Групповой',
        '27-12-2024 18:00'),
       ('Дает вам новые знакомства',
        'Нужно встретиться со случайным коллегой со случайного отдела и сходить выпить кофе', 'Рандом кофе', 'Парный',
        '30-11-2024 14:30');

insert into achievements (name)
values ('Сходить на 1 событие'),
       ('Сходить на 2 события'),
       ('Выиграть в 2 событиях');

insert into users_achievements (user_id, achievement_id)
values (1, 1),
       (1, 2),
       (2, 3),
       (2, 2),
       (3, 2);

insert into users_challenges (user_id, challenge_id)
values (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 2);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER'),
       (3, 'ROLE_USER');