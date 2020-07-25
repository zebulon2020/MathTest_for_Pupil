# MathTest_for_Pupil

Java program for math quizzes for elementary school students, also a Java curriculum project.

[English](README.md)  [中文](README_zh.md)  

#### Project description

For elementary 1~2 grade students, randomly select two integers and addition and subtraction to form an equation that requires students to solve.

Functional requirements.

+ (1) The computer randomly asks 10 questions for 10 points each and displays the student's score at the end of the program.
+ (2) Ensure that the arithmetic does not exceed the level of grade 1 to 2, that only addition and subtraction within 50 is allowed, and that the sum or difference between two numbers does not exceed the range of 0 to 50, and that negative numbers are not allowed.
+ (3) Students have three chances to enter their answers to each question, and when they enter a wrong answer, they are reminded to enter it again and output the correct answer if the three chances end.
+ (4) For each question, the student receives 10 points for the first correct answer, 7 points for the second correct answer, and 5 points for the third correct answer, otherwise no points are awarded.
+ (5) If the total score is over 90, "SMART" is displayed, 80-90, "GOOD" is displayed, 70-80, "OK" is displayed, 60-70, "GOOD" is displayed. "PASS", 60 or less "TRY AGAIN".

#### Experimental environment

This project is a Java project and begins with a Java project development environment.
In addition, the project uses a database, this project uses SQL Server 2008, the connected database name is **mydbname**, connected with administrator account **sa**, password **216059**, (if you want to clone it and run it locally, please modify the corresponding configuration in the DbOp.java file).
Create a new table user in the database, and add some initial accounts to log in.

**Note**: If you are using a MySQL database, modify the statements in DbOp.java and replace the jar in the lib directory with the corresponding MySQL package.

#### End

Thank you all for your attention.😄 😄 😄
