# Sparta-Trainees-Simulator

<img src="ProgramImages/sparta%20logo.png" align="right" width="120" />

![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-blue?style=for-the-badge&logo=appveyor)
![Log4J](https://img.shields.io/badge/-Log4J-orange?style=for-the-badge&logo=appveyor)
![IntelliJ](https://img.shields.io/badge/-IntelliJ-black?style=for-the-badge&logo=appveyor)
![JDK](https://img.shields.io/badge/-JDK-cyan?style=for-the-badge&logo=appveyor)
![JUnit](https://img.shields.io/badge/-JUnit-magenta?style=for-the-badge&logo=appveyor)
![agile](https://img.shields.io/badge/-Agile-yellow?style=for-the-badge&logo=appveyor)
![scrum](https://img.shields.io/badge/-Scrum-red?style=for-the-badge&logo=appveyor)
![cucumber](https://img.shields.io/badge/-Cucumber-darkgreen?style=for-the-badge&logo=appveyor)
![testing](https://img.shields.io/badge/-Testing-green?style=for-the-badge&logo=appveyor)

> Contributors:
>
> • Roberto Lovece - Junior Java SDET Consultant | [Portfolio](https://robertolovece.github.io/Portfolio-Website/) | [GitHub](https://github.com/RobertoLovece) | [LinkedIn](https://www.linkedin.com/in/roberto-lovece-20abb121a/) | 
>
> • Suyash Srivastava - Junior Java SDET Consultant | [GitHub](https://github.com/SuyashsGit) | [LinkedIn](https://www.linkedin.com/in/suyash-srivastava-0a977a15a/) |
>
> • Conor Porteous - Junior Java SDET Consultant | [GitHub](https://github.com/ThistleBlue22) | [LinkedIn](https://www.linkedin.com/in/conor-porteous/) |
>
> • Aiden Sykes - Junior Java SDET Consultant | [GitHub](https://github.com/AidenSykes1999) | [LinkedIn](https://www.linkedin.com/in/aiden-sykes/) |
> 
> • Piotr Sulek - Junior Java SDET Consultant | [GitHub](https://github.com/piotr02) | [LinkedIn](https://www.linkedin.com/in/piotr-sulek/) |
> 
> • Hassan Said - Junior Java SDET Consultant | [GitHub](https://github.com/HassanHSaid) | [LinkedIn](https://www.linkedin.com/in/hassan-said-b3270a181/) |
>
>


## **Table Of Contents**
* [**Overview**](#overview)
* [**What is simulation?**](#what-is-simulation)
* [**Project Planning (Sprints)**](#project-planning)
  - [Phase 1](#phase-1)
  - [Phase 2](#phase-2)
  - [Phase 3](#phase-3)
* [**Principles and Design Patterns**](#principles-and-design-patterns)
* [**Software and Dependencies**](#software-and-dependencies)
  - [IntelliJ](#intellij)
  - [Log4J (Logging framework)](#log4j)
  - [JDK](#jdk)
  - [Apache Maven](#apache-maven)
  - [JUnit Jupiter API](#junit-jupiter-api)
* [**How to use the application**](#how-to-use-the-application)
  - [How to download](#how-to-download)
  - [Instructions for running the application on the console](#instructions-for-running-the-application-on-the-console)
* [**Testing**](#testing)
  - [JUnit Testing](#junit-testing)
  - [Manual Testing](#manual-testing)
* [**Logging**](#logging)
* [**Future work**](#future-work)

### **Overview**
Sparta Global gave us a group project to replicate the company and its expansion, with trainees acting as agents who are allocated to either the waiting list or a training centre.
<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **What is simulation?**
A simulation is a model that mimics the operation of an existing or proposed system, providing evidence for decision-making by being able to test different scenarios or process changes.
<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Project Planning**
#### **Phase 1**
- The tracker needs to be able to track time in a consistent way
- The program starts by asking how long the simulation will run for
- Every month, a random number of trainees are generated wanting to be trained (50 - 100)
- Every 2 months, Sparta Global opens training centres. They open instantly and can take trainees every month
- A centre can train a max of 100 trainees and takes a random number of trainees every month. (0 - 50 trainees up to their capacity)
- If a centre is full, trainees can be moved to any other centre which is not full
- If all centres are full, the trainees go onto a waiting list. This list must be served first before new trainees are taken
- At the end of the simulation, output should show:
  - Number of open centres
  - Number of full centres
  - Number of trainees currently training
  - Number of trainees on the waiting list

#### **Phase 2**
- Sparta will now check centres each month. If a centre has fewer than 25 trainees, it will close. The trainees will be randomly moved to another suitable centre
- The simulation should now offer the choice of data at the end of the simulation or a running output updated each month
- Trainees will now have a course type (Java, C#, Data, DevOps or Business). A trainee will be randomly assigned a course when they are created. This will never change
- Sparta now has 3 different types of centre. When a new centre can be opened, one of the following will be randomly chosen
- Training Hub: can train a maximum of 100 trainees but 3 (randomly 1-3) can be opened at a time each month
- Bootcamp: can train a maximum of 500 trainees but can remain open for 3 months if there are fewer than 25 trainees in attendance. If a Bootcamp has 3 consecutive months of low attendance, it will close. For the lifetime of the simulation, only 2 Bootcamps can exist at a time
- Tech Centre: Can train 200 trainees but only teaches one course per centre. This is chosen randomly when a Tech Centre is open
- The simulation should report on the following:
  - Number of open centres (breakdown for each type)
  - Number of closed centres (breakdown for each type)
  - Number of full centres (breakdown for each type)
  - Number of trainees currently training (breakdown for each type)
  - Number of trainees on the waiting list (breakdown for each type)

#### **Phase 3**

- If a trainee has been in training for a year, they are moved to a bench state
- Clients will begin to be randomly created after 1 year of the simulation
- A client will have a requirement when they are created e.g a need for 27 Java trainees. The requirement can be any value greater than or equal to 15
- A client will take a random number of trainees from the bench each month (1 - full requirement) until their requirement is met
- A client will only take one type of trainee (Java, C#, Data, DevOps or Business)
- If a client does not collect enough trainees from the bench within a year, they will leave unhappy
- If a client does collect enough trainees from the bench within a year, they will leave happy and return the next year with the same requirement

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Principles and Design Patterns**
This application is based on the following principles and design principles:

- Model-view-controller: This is a software design pattern commonly used for developing user interfaces that divide the related program logic into three interconnected elements. This is done to separate internal representations of information from the ways information is presented to and accepted from the user.
- Object-oriented programming principles: These principles are also known as the 4 pillars of OOP: Abstraction, Inheritance, Encapsulation, and Polymorphism.
- SOLID principles: This application strongly follows SOLID principles i.e. Single responsibility, Open–closed, Liskov substitution, Interface segregation, and Dependency inversion principles.
- Factory pattern: Used to product and manage the trainee, centre and client objects in the simulation.

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Software and dependencies**
#### **IntelliJ**
IntelliJ IDEA is an integrated development environment written in Java for developing computer software. It is developed by JetBrains, and is available as an Apache 2 Licensed community edition, and in a proprietary commercial edition. Both can be used for commercial development.
- In this application we have used IntelliJ IDEA [Version 2021.3.2](https://www.jetbrains.com/idea/download/#section=windows)

#### **Log4J**
Log4j has been used by us to keep track of what happens in our sparta trainee simulation application. It is a journal of the activity of our application. This activity is called 'logging' and it has been used by us to keep an eye out for problems for users.
- In this application we have used [Version 2.17.1](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core/2.17.1) of Log4J API.
* _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
* Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.17.1</version>
    </dependency> 
```
#### **JDK**
The JDK is the Java Development Kit, the full-featured SDK for Java. It has everything the JRE has, but also the compiler (javac) and tools (like javadoc and jdb). It is capable of creating and compiling programs.
- In this application we have used JDK [Version 17.0.2](https://jdk.java.net/17/)
#### **Apache Maven**
Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
* _**Note:** This dependency can be imported using IntelliJ._
* _Go to **"File" > "New Project"** and then selecting **"Maven"** as the project structure._
#### **JUnit Jupiter API**

JUnit Jupiter is the API for writing tests using JUnit version 5. JUnit 5 is the project name (and version) that includes the separation of concerns reflected in all three major modules: JUnit Jupiter, JUnit Platform, and JUnit Vintage.
- In this application we have used JUnit Jupiter [Version 5.8.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.2)
* _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
* Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.2</version>
    </dependency>
```

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **How to use the application**

#### **How to download**
- Step 1: Click on the green 'Code' button and then choose the 'Download ZIP' option.
  <img src="ProgramImages/Step1Download.png"/>
- Step 2: Extract the file by double-clicking on the downloaded ZIP file.
  <img src="ProgramImages/Step2Download.png"/>
- Step 3: Open IntelliJ IDEA application, then click on File option (the option is in the top left corner of the screen) and then click on Open. Then navigate to the place where you have extracted the folder, select the folder and click 'Open'.
  <img src="ProgramImages/Step3Download.jpg"/>
  <img src="ProgramImages/Step3bDownload.png"/>
- Step 4: Click on 'Trust Project' button, and then Click on 'New Window'.
  <img src="ProgramImages/Step4Download.png"/>
  <img src="ProgramImages/Step4bDownload.png"/>
- Step 5: Look for Main.java class after following these steps: SpartaTraineesSimulator > src > main > java > com.sparta.spartatraineesimulator > Main.java
  <img src="ProgramImages/Step5Download.png"/>
- Step 6: Run the Main class (by clicking on the green triangle button) and enjoy the application.

#### **Instructions for running the application on the console**
- `1) Input the number of months you want to run the simualtion for.`
- `2) Input 1 or 0 for incremental or non-incremental display.`
- `3) View the output and enjoy!`

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Testing**

#### **Manual Testing**

- We have also used manual testing process in which test cases are executed manually where it was not possible to use any automated tool. All test cases here were executed manually according to the end user's perspective. This has been done to ensure whether the application is working, as mentioned in the requirements of the application.


#### **JUnit Testing**
- To provide a better performance to the user, all classes and methods in this application have been thoroughly tested using JUnit (unit testing framework).

Results: 

![CentreTest](https://user-images.githubusercontent.com/48356710/154861543-65d69ac2-160c-4841-9162-b3fc4de07658.png)
![ClientFactoryTest](https://user-images.githubusercontent.com/48356710/154861546-5993a329-6da1-4f92-8fb4-5b30609f248d.png)
![CourseRandomGeneratorTest](https://user-images.githubusercontent.com/48356710/154861547-179050b5-3609-4d8d-a535-1b57adb3ec88.png)
![CourseTest](https://user-images.githubusercontent.com/48356710/154861548-d79fb7c4-62ec-44e2-9dba-7ebb04da73d1.png)
![TraineeFactoryTest](https://user-images.githubusercontent.com/48356710/154861549-900697e8-a09a-4064-b94b-e329a294e3b6.png)
![CentreFactoryTest](https://user-images.githubusercontent.com/48356710/154861552-7ee4106e-2b68-4352-b374-aa1446c9c720.png)


<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>

### **Logging**

The levels of logging utilized where debug, info, warn.

Examples of where logging levels are used:

- Debug - logs the size of waiting and bench list.
- Info - logs when the simulation ends.
- Warn - logs when the user input an invalid option.

### **Future work**

Possible improvements for Sparta Trainee Simulator 2.0:
 - Add more training centres.
 - Make a GUI for this application.

<br/>
<div align="left">
    <b><a href="#table-of-contents">↥ Back to top</a></b>
</div>
<br/>
=============================== ENJOY THE APPLICATION ===============================

