# AddressBook
Deloitte Tech Tank Technical Assignment

## The Task

The task is to develop a small java application. 

## The application

Your application needs to read the provided AddressBook file and answer the following questions:

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?


## Tools

- JavaSE-17
- Eclipse as IDE (https://eclipseide.org/)
- JUnit 5 for unit tests.

### Java Version

openjdk version "17.0.10" 2024-01-16 LTS  
OpenJDK Runtime Environment Microsoft-8902769 (build 17.0.10+7-LTS)  
OpenJDK 64-Bit Server VM Microsoft-8902769 (build 17.0.10+7-LTS, mixed mode, sharing)  

## How to launch application

To launch the application without using Eclipse, a JAR file is provided. The jar is located in the "AddressBook" folder.  

To launch the jar, use this command in command line:  
- cd AddressBook; java -jar .\AddressBook.jar -> On Windows PowerShell
- cd AddressBook; java -jar ./AddressBook.jar -> On Linux

## Overview

The program is segmented into several parts.

### User

Represents an entry in the address book  
Defined by a name, a gender and a birth date  
The attributes were determined based on the provided data file, using the following schema : NAME, GENDER, BIRTHDATE  

### AddressBook

Represents an address book  
Used to manipulate Users  
Require the use of init() method to function  
Allows to retrieve an User based on their name  

### Gender

Enumeration used to define the gender of an User  
--> MALE, FEMALE, OTHER  
Allows to retrieve the enum constant according to a string  

### CustomFileReader

Used to read the data file and create a list of Users based on it  

### Constants

Static class storing constants used during the application, such as error messages and messages related to questions  

### Question

Static class used to resolve questions asked  

Questions asked :

	- How many males are in the address book?
	- Who is the oldest person in the address book?
	- How many days older is Bill than Paul?
			

## Coverage

### User
![UserCoverage](https://github.com/Skialogia/AddressBook/assets/73537037/e3b7ad06-b1a0-485d-ad06-5bb576df8fa2)

### AddressBook
![AddressBookCoverage](https://github.com/Skialogia/AddressBook/assets/73537037/3283b70a-c5fd-4da1-9dcc-70549c360451)

### CustomFileReader
![CustomFileReaderCoverage](https://github.com/Skialogia/AddressBook/assets/73537037/77145667-071e-4dc8-a811-e4a30b6c0ba6)

### Question
![QuestionCoverage](https://github.com/Skialogia/AddressBook/assets/73537037/a83daff2-26a6-4a6f-a78a-fe9b006e9173)
