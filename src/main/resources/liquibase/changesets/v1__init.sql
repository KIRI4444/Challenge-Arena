create table if not exists challenge_arena.users
(
    id bigserial primary key,
    name varchar(255) not null,
    username varchar(255) not null unique,
    password varchar(255) not null,
    goals varchar(255),
    age int not null,
    description varchar(1025),
    sex int not null
);

create table if not exists challenge_arena.challenges
(
    id bigserial primary key,
    description varchar(255) not null,
    rules varchar(255) not null,
    title varchar(255) not null,
    type varchar(255) not null,
    date timestamp not null
);

create table if not exists challenge_arena.achievements
(
    id bigserial primary key,
    name varchar(255) not null
);

create table if not exists challenge_arena.users_challenges
(
    user_id bigint not null,
    challenge_id bigint not null,
    primary key(user_id, challenge_id),
    constraint fk_users_challenges_users foreign key (user_id) references challenge_arena.users(id) on delete cascade on update no action,
    constraint fk_users_challenges_challenges foreign key (challenge_id) references challenge_arena.challenges(id) on delete cascade on update no action
);

create table if not exists challenge_arena.users_roles
(
    user_id bigint       not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references challenge_arena.users(id) on delete cascade on update no action
);

create table if not exists challenge_arena.users_achievements
(
    user_id bigint not null,
    achievement_id bigint not null,
    primary key(user_id, achievement_id),
    constraint fk_users_achievements_users foreign key (user_id) references challenge_arena.users(id) on delete cascade on update no action,
    constraint fk_users_achievements_achievements foreign key (achievement_id) references challenge_arena.achievements(id) on delete cascade on update no action
);