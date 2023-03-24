# ticket-booking
Seat reservation system for a cinema

## Technologies Used
Java 17

Spring Web

Spring Data JPA

H2 Database

## Features

User can:

* View dates that have screenings
* View all screenings with title, start time and date
* View screenings by date
* View screenings by date and time interval
* View screening with title, start time, date, room number and list of seats by title, date and time
* Make a reservation by writing screeningId, name, surname and chosen seats

## Test Data

```
INSERT INTO movies (id, title) VALUES
(1, 'Batman'),
(2, 'Nobody'),
(3, 'Braveheart');
INSERT INTO screenings (id, movie_Date, movie_Start_Time, movie_id) VALUES
(1, '2023-02-15', '15:30', 1),
(2, '2023-02-15', '17:30', 1),
(3, '2023-02-15', '15:00', 2),
(4, '2023-02-15', '16:00', 3),
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
(7, 2, 1, true, 1), (8, 2, 2, true, 1), (9, 2, 3, true, 1), (10, 2, 4, true, 1), (11, 2, 5, true, 1), (12, 2, 6, true, 1);
```

## Postman

### To view dates:

URL: 
```
http://localhost:8080/screenings/dates
```

### To view screenings:

URL: 
```
http://localhost:8080/screenings/all
```

### To view screenings by date:

URL: 
```
http://localhost:8080/screenings/by-date?date=2023-02-16
```

### To view screenings by date and interval:

URL: 
```
http://localhost:8080/screenings/interval?date=2023-02-15&startTime=15:00&endTime=17:00
```

### To view screening with room information:

URL: 
```
http://localhost:8080/screenings/room?title=Batman&date=2023-02-15&time=15:30
```

### To make a reservation:

Name and surname have to be at least 3 characters long, starting with capital letter. Surname can consist of two parts separated with a single dash, the second part has to start with a capital letter.

When making a reservation there cannot be a single vacant seat left

URL: 
```
http://localhost:8080/reservation
```

JSON body to make a reservation:
```
{
    "screeningId": 1,
    "name": "Jan",
    "surname": "Kowalski-Kal",
    "seats": [
        {
            "id": 1,
            "ticketType": "Adult"
        },
        {
            "id": 2,
            "ticketType": "Child"
        }
    ]
}
```
Response:
```
{
    "ticketCost": 37.5,
    "userName": "Jan",
    "userSurname": "Kowalski-Kal",
    "seats": [
        {
            "seatRow": 1,
            "seatNumber": 1,
            "ticketType": "Adult"
        },
        {
            "seatRow": 1,
            "seatNumber": 2,
            "ticketType": "Child"
        }
    ]
}
```
