# ticket-booking
Seat reservation system for a multiplex

## Technologies Used
Java 17

Spring Web

Spring Data JPA

H2 Database

## Features

User can:

* View all screenings with title, start time and date
* View dates that have screenings
* View screenings by date
* View screenings by date and time interval
* View particular screening with title, start time, date, room number and list of seats by title, date and time
* Make a reservation by writing screeningId, name, surname and chosen seats

JSON body for making a reservation:
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
