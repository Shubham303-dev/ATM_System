# Author - Shubham Kumar

# Description - I have prepared ATM program to perform various activities like depositing the money, withdraw money and checking balance .In this we used to access their bank accounts in order to make cash withdrawals. Whenever the user want to perform any action , they can enter their PIN number (personal identification number) and they can perform their task. 

# Technology Used - JAVA , JDBC, MYSQL. 

# Database name - ATMSystem
# Table name - account
# Class.forName("com.mysql.cj.jdbc.Driver");
# String url="jdbc:mysql://localhost:3306/ATMSystem";
# String username="root";
# String password="mysql";
# create table account(id int primary key,cardNumber varchar(255) unique not null,pin int not null,amount double not null);
