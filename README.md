# Spring-Boot-Web-App

It's a spring boot based web-app for managing results of students of various classes for different subjects. It supports the following functionality using rest apis :
1. To create students ( Roll Number, Name, Class/Standard)
2. To enter marks for each subject of every student.
3. To edit or delete any student
4. To edit or delete marks of any subject of any student.
5. To search any student on the basis of roll no.
6. To fetch list of subjects & marks for any student.
7. To fetch students who scored an aggregate marks more than any user entered percentage.
8. To fetch top scorers of each subject.

The application has been broken into following standard modules for enhancing readability :
   
# Controller

1. StudentController : To add/delete/update students and their details.
2. MarksController : To add/delete/update marks of different subjects for students of various classes. It also supports apis to fetch top scoreres of different subjects in various classes and to get the list of students having percentage more than a specified value.
  
# Service
It contains the business logic and the implementation to support the above listed fuctionalities and is again divided into 2 parts like the controller :
1. StudentService
2. MarksService
  
# Repository(DAO)
This is the data access layer, where database related operations are written. Database used is MySql and Crudrepository offer by Spring-Boot-Data-JPA has been used for the database related operations. DB Schema consists of following 2 tables:
1. Student : stores name, standard and roll number of the students.
2. Marks : stores student's marks in different subjects.
    
# Swagger
Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON. It keeps the documentation of all the exposed rest api's.
  
  
  
 


