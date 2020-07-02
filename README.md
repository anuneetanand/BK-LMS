
# Bharat Kaksha

***A database management system and portal designed specifically for government schools with a beautiful and user-friendly UI. The stakeholders include Students, Guardians, Teachers, Administration and Education Ministry. Being a centralised database for all government schools, Education Ministry is provided insights about performance of various schools using smart systems and dynamic graphs. Privacy and security of user data were not compromised while designing the database.***

![enter image description here](https://raw.githubusercontent.com/anuneetanand/Images/master/DBMS/BK-1.png)


## Build Database

To create a local empty MySQL database
```
$ mysql database_name < Database/Project_Tables.sql
```
To use the sample MySQL database
```
$ mysql database_name < Database/Database.sql
```

## Build Project

Add necessary Database details.
Build the project as JavaFX app with required dependancies into a JAR file.
Execute the JAR file.

## Dependancies

 - Java 11.0.2
 - JavaFX 11
 - Jfeonix 9
 - mysql-connector-java:8.0.5

## Preview

### Login Page
![enter image description here](https://raw.githubusercontent.com/anuneetanand/Images/master/DBMS/BK-2.png)

### Student Page

- View marks in different subjects.
- View Attendance
- View recent notices.
- View due assignments.
- Give feedback to Teachers.

![enter image description here](https://raw.githubusercontent.com/anuneetanand/Images/master/DBMS/BK-3.png)

### Guarduan Page

- View ward's performance
- Keep track of ward's attendance.
- View infomation about different schools.
- Pay fees.

![enter image description here](https://raw.githubusercontent.com/anuneetanand/Images/master/DBMS/BK-4.png)

### Teacher Page

- Add new assignment.
- Analysis of marks of students.
- View Feedback rating.

![enter image description here](https://raw.githubusercontent.com/anuneetanand/Images/master/DBMS/BK-5.png)

### Administration Page

- Enroll Student.
- Enroll Teacher.
- Check fee defaulters.

![enter image description here](https://raw.githubusercontent.com/anuneetanand/Images/master/DBMS/BK-6.png)

### PerformX

- Analysis perfomance of various schools on different parameters using dynamic graphs.
- Calculate scores based on analysis.

![enter image description here](https://raw.githubusercontent.com/anuneetanand/Images/master/DBMS/BK-7.png)
