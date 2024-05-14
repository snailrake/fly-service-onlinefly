INSERT INTO subject (name)
VALUES ('Веб-разработка'),
       ('Технологии программирования'),
       ('Теория алгоритмов');

INSERT INTO team (name)
VALUES ('б1-ИЛПС-11'),
       ('б1-ОСА-11'),
       ('б1-ИСП-11'),
       ('б1-НЛО-11');

INSERT INTO users (login, name, team_id, mail, password, role)
VALUES ('ponomarev', 'Пономарёв Пантелей Ильяович', 1, 'bgh050021@gmail.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('testuser', 'Тихонова Полина Григорьевна', 2, 'petrov@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('user', 'Белов Артём Кириллович', 3, 'sidorov@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('useruseruser', 'Дьяконова Алиса Максимовна', 4, 'useruseruser@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('samsonova', 'Самсонова София Павловна', 1, 'samsonova@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('bobrov', 'Бобров Давид Максимович', 1, 'bobrov@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('nazarov', 'Назаров Дмитрий Дмитриевич', 1, 'nazarov@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('philipov', 'Филиппов Михаил Иванович', 1, 'philipov@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('muhin', 'Мухин Александр Михайлович', 1, 'muhin@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('pavlov', 'Павлов Владислав Алиевич', 1, 'pavlov@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('tihonov', 'Тихонов Игорь Степанович', 1, 'tihonov@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('rijova', 'Рыжова Ольга Арсентьевна', 1, 'rijova@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER'),
       ('trofimovna', 'Трифонова Ева Максимовна', 1, 'trofimovna@example.com',
        '$2a$05$NFRQapXaSlYmD1EwjSLc8etad6/aXOUhIUKKqikhrzsYRT.rKJ2O2', 'USER');

INSERT INTO users (login, name, mail, password, role)
VALUES ('simonov', 'Симонов Сергей Сергеевич', 'simonov@example.com',
        '$2a$05$lZIx3Wk3/8l8lt1aRljkhe8EOIUJe5nofaB38Unsq0ivs4//JdSne', 'ADMIN');

INSERT INTO fly (name, subject_id, questions_per_try, start_date, end_date, time)
VALUES ('Тест по Java', 1, 15, '2024-01-13 00:00:00', '2025-12-13 00:00:00', 900),
       ('Тест по HMTL', 1, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 3600),
       ('Тест по CSS', 1, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 2700),
       ('Тест по JS', 1, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 3600),
       ('Тест по Python', 2, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 900),
       ('Тест по React', 1, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 2700),
       ('Тест по Angular', 1, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 3600),
       ('Тест по Envelope', 3, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 2700),
       ('Тест по ./flash', 3, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 900),
       ('Тест по Frontend', 1, 15, '2022-01-13 00:00:00', '2023-12-13 00:00:00', 3600);

INSERT INTO question (content, fly_id)
VALUES ('Что такое ООП?', 1),
       ('Что такое класс в Java?', 1),
       ('Как объявить класс в коде?', 1),
       ('Для чего используется оператор new?', 1),
       ('Что означает ключевое слово extends?', 1),
       ('Что означает перегрузка метода в Java (overload)?', 1),
       ('Что означает переопределение метода в Java (override)?', 1),
       ('Чем отличаются static-метод класса от обычного метода класса?', 1),
       ('Можно ли вызвать static-метод внутри обычного?', 1),
       ('Для чего необходимо ключевое слово this', 1),
       ('Какой из этих методов класса String используется для получения длины объекта String?', 1),
       ('Что из следующего является ключевым словом в Java?', 1),
       ('Что из следующего не является ключевым словом в Java?', 1),
       ('Какое из этих ключевых слов используется для предотвращения изменения содержимого переменной?', 1),
       ('Какой метод используется для выполнения какого-либо действия, когда объект должен быть уничтожен?', 1);

INSERT INTO answer (content, question_id)
VALUES ('Объектно-ориентированное программирование — методология программирования, основанная на представлении программы в виде совокупности объектов, каждый из которых является экземпляром определенного класса, а классы образуют иерархию наследования',
        1),
       ('Объектно-ориентированное программирование — так называют любой тип программирования, в котором используются понятия высокого уровня и, в отличие от Assembler, в котором не работают напрямую с ячейками памяти ПК',
        1),
       ('Объектно-ориентированное программирование — просто красивое понятие. Если вдуматься, оно не несет дополнительной смысловой нагрузки, просто программисты любят аббревиатуры, так области их знаний выглядят сложнее',
        1),
       ('Очень одинокий программист', 1),
       ('Уровень сложности программы. Все операторы делятся на классы в зависимости от сложности их использования', 2),
       ('Базовый элемент объектно-ориентированного программирования в языке Java', 2),
       ('Просто одно из возможных названий переменной', 2),
       ('Такое понятие есть только в C++, в Java такого понятия нет', 2),
       ('class MyClass {}', 3),
       ('new class MyClass {}', 3),
       ('select * from class MyClass {}', 3),
       ('MyClass extends class {}', 3),
       ('Для создания новой переменной', 4),
       ('Для объявления нового класса', 4),
       ('Для создания экземпляра класса', 4),
       ('Это антагонист оператора OLD', 4),
       ('Что данный класс наследуется от другого', 5),
       ('Что это дополнительный модуль класса, который расширяет его свойства', 5),
       ('Что два класса делают одно и то же', 5),
       ('Что это самый большой класс в программе', 5),
       ('Изменение поведения метода класса относительно родительского', 6),
       ('Изменение поведения метода класса относительно дочернего', 6),
       ('Несколько методов с одинаковым названием, но разным набором параметров', 6),
       ('Несколько разных классов с одинаковым методом', 6),
       ('Изменение поведения метода класса относительно родительского', 7),
       ('Изменение поведения метода класса относительно дочернего', 7),
       ('Несколько методов с одинаковым названием, но разным набором параметров', 7),
       ('Несколько разных классов с одинаковым методом', 7),
       ('Поведение обычного метода класса можно изменить в классе-наследнике, а поведение static-метода нельзя', 8),
       ('Обычный метод класса можно переопределить, а static-метод нельзя', 8),
       ('Обычный метод класса работает от объекта класса, а static-метод от всего класса', 8),
       ('Static-метод класса можно вызывать только внутри класса, а обычный - в любой части кода', 8),
       ('Никак, static-метод можно вызвать только от объекта класса', 9),
       ('Можно, надо перед этим перегрузить обычный метод класса', 9),
       ('Можно, надо перед этим переопределить обычный метод класса', 9),
       ('Можно, ничего дополнительно делать не надо', 9),
       ('Это указатель на переопределенный метод класса. Его нельзя опускать при вызове, иначе переопределение не сработает',
        10),
       ('Это указатель на текущий объект класса внутри самого класса', 10),
       ('Это не ключевое слово', 10),
       ('Это ключевое слово для вызова обычного метода внутри static-метода. Его нельзя опускать, иначе вызов не сработает и будет ошибка',
        10),
       ('length()', 11),
       ('lengthOf()', 11),
       ('Sizeof()', 11),
       ('get()', 11),
       ('file', 12),
       ('if', 12),
       ('that', 12),
       ('Ничего из вышеперечисленного', 12),
       ('if', 13),
       ('try', 13),
       ('else', 13),
       ('Ничего из вышеперечисленного', 13),
       ('static', 14),
       ('constant', 14),
       ('last', 14),
       ('final', 14),
       ('main()', 15),
       ('delete()', 15),
       ('finalize()', 15),
       ('Ничего из вышеперечисленного', 15);

UPDATE question
SET answer_id =
        CASE
            WHEN content = 'Что такое ООП?' THEN 1
            WHEN content = 'Что такое класс в Java?' THEN 6
            WHEN content = 'Как объявить класс в коде?' THEN 9
            WHEN content = 'Для чего используется оператор new?' THEN 15
            WHEN content = 'Что означает ключевое слово extends?' THEN 17
            WHEN content = 'Что означает перегрузка метода в Java (overload)?' THEN 23
            WHEN content = 'Что означает переопределение метода в Java (override)?' THEN 25
            WHEN content = 'Чем отличаются static-метод класса от обычного метода класса?' THEN 31
            WHEN content = 'Можно ли вызвать static-метод внутри обычного?' THEN 36
            WHEN content = 'Для чего необходимо ключевое слово this' THEN 38
            WHEN content = 'Какой из этих методов класса String используется для получения длины объекта String?'
                THEN 41
            WHEN content = 'Что из следующего является ключевым словом в Java?' THEN 46
            WHEN content = 'Что из следующего не является ключевым словом в Java?' THEN 52
            WHEN content =
                 'Какое из этих ключевых слов используется для предотвращения изменения содержимого переменной?' THEN 56
            WHEN content =
                 'Какой метод используется для выполнения какого-либо действия, когда объект должен быть уничтожен?'
                THEN 59
            ELSE NULL
            END;

INSERT INTO fly_result (student_id, fly_id, score, time, lost_focus)
VALUES ('testuser', 1, 12, 4312, false),
       ('user', 1, 91, 5431, true),
       ('useruseruser', 1, 16, 6521, false),
       ('samsonova', 1, 29, 4232, false),
       ('bobrov', 1, 56, 1234, true),
       ('nazarov', 1, 31, 245, false),
       ('philipov', 1, 97, 532, false),
       ('muhin', 1, 52, 539, true),
       ('pavlov', 1, 25, 1789, false),
       ('tihonov', 1, 58, 1522, false),
       ('rijova', 1, 11, 2222, false);

