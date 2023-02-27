INSERT INTO movies (id, title) VALUES
(1, 'Batman'),
(2, 'Nobody'),
(3, 'Northman');
INSERT INTO screenings (id, movie_Date, movie_Start_Time, movie_id) VALUES
(1, '2023-02-15', '15:00', 1),
(2, '2023-02-15', '17:30', 1),
(3, '2023-02-15', '15:00', 2),
(4, '2023-02-15', '18:00', 3),
(5, '2023-02-16', '15:30', 3),
(6, '2023-02-16', '17:30', 2);
INSERT INTO rooms (id, room_Number) VALUES
(1, 1),
(2, 2),
(3, 3);
INSERT INTO screening_room (screening_id, room_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3);
INSERT INTO seats (id, seat_row, seat_number, availability, room_id) VALUES
(1, 1, 1, true, 1), (2, 1, 2, true, 1), (3, 1, 3, true, 1), (4, 1, 4, true, 1), (5, 1, 5, true, 1), (6, 1, 6, true, 1),
(7, 2, 7, true, 1), (8, 2, 8, true, 1), (9, 2, 9, true, 1), (10, 2, 10, true, 1), (11, 2, 11, true, 1), (12, 2, 12, true, 1);



