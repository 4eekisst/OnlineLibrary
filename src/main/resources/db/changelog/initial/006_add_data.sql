INSERT INTO authorities (authority)
VALUES ('user'), ('admin');

INSERT INTO users (name, surname, patronymic, address, passport_number, reader_card_number, password, authority_id)
VALUES ('qwe', 'qwe', 'qwe', 'г. Москва, ул. Пушкина, д. 1', '1234567890', 'ACC001', '$2a$12$LLpVcDif4Q/gw1q/pgmPouii/gN/c5PpDeHJBBOiULc/5Idkf3fJ2', 1),
       ('Адиль', 'Рысбаев', 'Бектурович', 'г. Ош, ул. Крупская, д. 8', '0987654321', 'ACC002', '$2a$12$LLpVcDif4Q/gw1q/pgmPouii/gN/c5PpDeHJBBOiULc/5Idkf3fJ2', 1),
       ('admin', 'admin', 'admin', 'г. Санкт-Петербург, ул. Невский, д. 3', '1122334455', 'ACC003', '$2a$12$LLpVcDif4Q/gw1q/pgmPouii/gN/c5PpDeHJBBOiULc/5Idkf3fJ2', 2);

INSERT INTO categories (name, description)
VALUES ('Фантастика', 'Книги в жанре фантастики'),
       ('Научная литература', 'Книги по науке'),
       ('Приключения', 'Приключенческие романы');

INSERT INTO books (title, author, category_id, image)
VALUES ('1984', 'Джордж Оруэлл', 1, '1984.jpg'),
       ('Мастера и Маргарита', 'Михаил Булгаков', 1, 'master_i_margarita.jpg'),
       ('Краткая история времени', 'Стивен Хокинг', 2, 'history_of_time.jpg'),
       ('Война и мир', 'Лев Толстой', 3, 'war_and_peace.jpg');

INSERT INTO book_requests (user_id, book_id, request_date, return_date, status)
VALUES  (1, 1, '2024-10-01', '2024-10-15', 'ожидает'),
        (2, 2, '2024-10-02', '2024-10-16', 'возвращен'),
        (3, 3, '2024-10-03', '2024-10-17', 'ожидает');


