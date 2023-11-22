insert into bikeshop.user_roles (id, role)
values  (1, 'USER'),
        (2, 'ADMIN');

insert into bikeshop.users (id, last_name, address, created, email, first_name, modified, password)
values  (1, 'Mustermann', 'addressss', '2023-11-21', 'p@example.com', 'Petya', null, 'bca227cf465af27bf9546bb95d3c5edfb6cb64ec3aac91e5b26ff4e47e607bbc1070ef2cd53427bed8473c26c38f6ed9'),
        (2, 'Zimmermann', 'Hofstrasse 2', '2023-11-21', 'e@example.com', 'Emily', null, '91c3fc505d22450c3e0348ab3a0d19de57e0a1dbbc4339e1a1c235b8282dee5d1d2b9e822b8f21d11021a96d5a142629'),
        (3, 'TestLN', 'address', '2023-11-21', 't@example.com', 'TestFN', null, 'a56394f7565a1cdf63d1c5236ad5e759638a4a4026cdc390ec99a67629d47a4848902481a88fddf741a0f3617bdedfaf');

insert into bikeshop.users_roles (user_id, roles_id)
values  (1, 2),
        (2, 1),
        (3, 1);