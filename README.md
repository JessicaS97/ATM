# ATM
This project simulates the common transactions and functionalities of an ATM. A user and log in using its details, it can withdraw money from the ATM, check its balance and deposit money.

***

## Site is Live At:

**Project Start Date:** 13/02/2020

**Project Fnish Date:** 16/02/2020

**What This Project Is For Me**
1) Java Practice: the first time I used Java was on my first year at university. After, I had exposure to various other programming skills and their applications. Hence, I wanted to brush up my Java skills by bulding this Java based Bank Management System Simulator.
2) MySQL Pratice: I took a Data & Information Management (ISYS2120) course as part of my degree where I learnt concepts such as Conceptual Data Design, Relational Model and SQL, Logical Schema Design, Queries, among other concepts. However, I didn't quite have the opportunity to create a program and apply those concepts as part of the Database Management. This project allows me to not only review SQL theory but combine them with a platform built by myself, storing data from users, and managing those data.

### Day 1: MySQL DataBase setup and conection with NetBeans in Java (testing)
Basic functionalities like filter search bar, displaying users from database and adding new users
<img src="img/pic1.png" height="380" width="340">
<img src="img/pic2.png" height="380" width="340">
<img src="img/pic3.png" height="380" width="340">

**Register Form**

Work progress: checking all fields have been filled, verifying user has not been registered before, saving all details in DB

<img src="img/pic4.png" height="380" width="360"> <img src="img/pic5.png" height="380" width="360">
<img src="img/pic6.png" height="380" width="360"> <img src="img/pic7.png" height="380" width="360">

### Day 2: Login form and its link to Register form

Work progress: search up user in DB and validate credentials before logging into the system, randomly generate card number for user with auto increment to store in DB and ensure its uniqueness.

<img src="img/pic8.png" height="380" width="360">
<img src="img/pic9.png" height="300" width="370"> <img src="img/pic10.png" height="300" width="370"> <img src="img/pic11.png" height="300" width="370">

### Day 3: Menu for user to make transactions

Work progress: basic transactions will allow users to view account balance, transfer money to other users, withdraw money, deposit money, and change pin code.

Challenge: writing the correct query syntax to retrieve balance information with passed used id. Had to use relational JOIN query to connect users table to accounts table through the mappings table in DB 

<img src="img/pic12.png" height="300" width="340"> <img src="img/pic13.png" height="380" width="360"> 
<img src="img/pic14.png" height="300" width="360">

All functionalities which I wanted my ATM to include have been completed, with error checkings and successful retrieval and update of the DB.

## Built with:
* Java 
* JDBC API
* MySQL - Database Management
* NetBeans IDE
