# Checkout-Counter

Technologies: Java(Java8), Spring Boot, Maven3, MySQL or later.

This section outlines the information necessary to install and operate the application on the local machine.

### Prerequisites
 - Java(Java8) installed in system. [http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

 - Maven installed in system. [http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi).

 - IntelliJ IDEA Ultimate Edition installed in system. [http://www.jetbrains.com/idea/download/](http://www.jetbrains.com/idea/download/)
   or any other IDE
   
 - MySQl installed in system. https://dev.mysql.com/downloads/
 
 ### Operating Instructions

 - Clone the remote repository in your local machine
    - $ `git clone https://github.com/aditimantri15/checkout-counter.git`

 - Launch IntelliJ IDEA Ultimate Edition.

 - Import Project

    - Import project from directory where the clone of the repository is made.
 
 - Create database checkout_counter. And update datasource username and password in application.properties

 - Build project and download all dependencies.
    - $ `mvn clean install`
    
 - Run Application
 
 - Application will be launched at http://localhost:8080/
