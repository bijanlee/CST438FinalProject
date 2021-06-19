# CST438FinalProject

## Package Bookings Team
- Bijan Pourazari
- Christian Salas

## SQL Configuration
    |  Packages       |
    -------------------
    | package_id      |
    | user_id         |
    | hotel_id        |
    |  car_id         |
    | flight_id       |
    | itenerary_number|

## Controller Configuration

    `` controllers/HomeController ``
    - Resposible for the home route and searching for and creating packages

    ```controllers/AuthController```
    - Resposible for authenticating a user when logging in and allows a user to create a new account

## Routes

    ```/profile```
    When a user is signed in, they can view all the packages they have ordered.

    ```/SearchHotels```
    When a user is signed in, they can search hotels to add to package

    ```/SearchFlights```
    When a user is signed in, they can search flights to add to package

    ```/SearchCarLocations```
    When a user is signed in, they can search cars to add to package