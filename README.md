
# Bharat Kaksha

A database management system and portal designed specifically for government schools with a beautiful and user-friendly UI. The stakeholders include Students, Guardians, Teachers, Administration and Education Ministry. Being a centralised database for all government schools, Education Ministry is provided insights about performance of various schools using smart systems and dynamic graphs.

<img width="1278" alt="BK-1" src="https://user-images.githubusercontent.com/42066451/118356454-e82c4480-b592-11eb-8b56-29bb1c995911.png">

## Folder Structure
```
├── Database
│   ├── DataPopulation.py
│   ├── Database.sql
│   └── Project_Tables.sql
├── LICENSE
├── README.md
├── Report.pdf
├── Schema.png
└── src
    └── sample
        ├── Admin.fxml
        ├── ConnectDB.java
        ├── ControllerAdmin.java
        ├── ControllerError.java
        ├── ControllerGovt.java
        ├── ControllerGuardian.java
        ├── ControllerHindi.java
        ├── ControllerHome.java
        ├── ControllerLogin.java
        ├── ControllerStudent.java
        ├── ControllerTeacher.java
        ├── ControllerTeam.java
        ├── ControllerX.java
        ├── Error.fxml
        ├── Govt.fxml
        ├── Guardian.fxml
        ├── Hindi.fxml
        ├── Home.fxml
        ├── Login.fxml
        ├── Main.java
        ├── PerformX.fxml
        ├── Resources
        ├── Student.fxml
        ├── Teacher.fxml
        └── Team.fxml
```

## Build Database :bar_chart:

To create a local empty MySQL database
```
$ mysql database_name < Database/Project_Tables.sql
```
To use the sample MySQL database
```
$ mysql database_name < Database/Database.sql
```

## Build Project :wrench:

- Build a local copy of MySQL database
- Build the project as JavaFX app with required dependancies into a JAR file.
- Execute the JAR file.

## Dependancies :gear:

 - Java 11.0.2
 - JavaFX 11
 - Jfeonix 9
 - mysql-connector-java:8.0.5

## Preview :star:

### Login Page

<img width="1272" alt="BK-2" src="https://user-images.githubusercontent.com/42066451/118356469-02feb900-b593-11eb-8cb6-350629a35d87.png">

### Student Page

- View marks in different subjects.
- View Attendance
- View recent notices.
- View due assignments.
- Give feedback to Teachers.

<img width="1278" alt="BK-3" src="https://user-images.githubusercontent.com/42066451/118356477-0a25c700-b593-11eb-975c-e708fa9ec41f.png">

### Guardian Page

- View ward's performance
- Keep track of ward's attendance.
- View infomation about different schools.
- Pay fees.

<img width="1275" alt="BK-4" src="https://user-images.githubusercontent.com/42066451/118356485-17db4c80-b593-11eb-8b93-944e5f7ba29e.png">

### Teacher Page

- Add new assignment.
- Analysis of marks of students.
- View Feedback rating.

<img width="1278" alt="BK-5" src="https://user-images.githubusercontent.com/42066451/118356492-20338780-b593-11eb-84eb-8be4b2c058c6.png">

### Administration Page

- Enroll Student.
- Enroll Teacher.
- Check fee defaulters.

<img width="1279" alt="BK-6" src="https://user-images.githubusercontent.com/42066451/118356497-288bc280-b593-11eb-8cd4-e1e6a284609b.png">

### PerformX

- Analysis perfomance of various schools on different parameters using dynamic graphs.
- Calculate scores based on analysis.

<img width="1277" alt="BK-7" src="https://user-images.githubusercontent.com/42066451/118356500-2fb2d080-b593-11eb-849a-4b0af4ee4f67.png">

