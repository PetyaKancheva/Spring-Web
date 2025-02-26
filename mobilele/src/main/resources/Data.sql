INSERT INTO users (id, is_active, email, first_name, last_name, password)
VALUES
    (1, true, 'admin@example.com', 'Admin', 'Adminov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
(2,true, 'k@example.com','p','k','9a1f7bd0789f806a88f6c56d2ca81e4e629c739308dc283d5372e91d43363b020034511a1625ddfd1197048767e53c18');

INSERT INTO user_roles` (`id`, `role`)
    VALUES
    (1, ''Toyota''),
    (2, ''Ford'');
INSERT INTO `brands` (`id`, `name`)
VALUES
    (1, 'Toyota'),
    (2, 'Ford');

INSERT INTO `models` (`id`, `category`, `brand_id`, `name`,`start_year`,`end_year`,`image_url`)
VALUES
    (1, 'CAR', 1, 'Camry','1982','2199','https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/2018_Toyota_Camry_%28ASV70R%29_Ascent_sedan_%282018-08-27%29_01.jpg/1920px-2018_Toyota_Camry_%28ASV70R%29_Ascent_sedan_%282018-08-27%29_01.jpg'),
    (2, 'CAR', 1, 'Corolla','1966','2199','https://upload.wikimedia.org/wikipedia/commons/8/89/2019_Toyota_Corolla_Design_VVT-i_HEV_1.8_Front.jpg'),
    (3, 'CAR', 2, 'Focus','1998','2199','https://en.wikipedia.org/wiki/Ford_Focus#/media/File:2018_Ford_Focus_ST-Line_X_1.0.jpg'),
    (4, 'CAR', 2, 'Fiesta','1976','2023','https://en.wikipedia.org/wiki/Ford_Fiesta#/media/File:Ford_Fiesta_ST-Line_(VII,_Facelift)_%E2%80%93_f_30012023.jpg');


