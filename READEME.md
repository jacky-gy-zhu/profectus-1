# INSTRUCTIONS

## OVERVIEW 
This is a SpringBoot Maven project, so the source codes are in the "src/main" folder and the test codes are in the "src/test" folder.

These code challenge tasks looks perfect except for a little bit demo issue in the document like the 3 tier Discount_rate is 7.5% but the sample is 7% :)

In other thing is I didn't use postgres, but H2 instead. The reason is that H2 can be embedded into SpringBoot application just like tomcat, which means you don't have to install anything before you startup the application.

## INSTALLATION
Their are two ways to startup the application.
# IntelliJ IDEA
You can open the project folder by IntelliJ IDEA. Then go to "src/main/java/com/profectus/interview/InterviewApplication.java" run InterviewApplication. It will startup by SpringBoot and you can check it on Chrome by http://localhost:8080/
# External Tomcat 9
You also can package the maven project and put the file interview-0.0.1-SNAPSHOT.war into tomcat webapp folder. In order to make it easy, you can rename the file name to ROOT.war so that you can check it on Chrome by http://localhost:8080/
# logger
You need to config the log path in file "src/main/resources/application.yml", or logger will be generate under the project root path.
# port
Make sure you leave the port 8080 for this project, or you can config it in application.yml as well.

## DATABASE
Now that I use embedded database H2, you don't have to do anything to start the database. But be aware that the initial data script will be auto run after the application started up, which you can find them in "src/main/resources/data.sql". And also be aware that I set the data store level is memory, which means every time you restart the application, the data will be clean and refresh.

## ASSUMPTION
For the tiered claim calculator, the tier config is provided by database as the requirements says. But this used to be in the config file since it will never be changed once the application started up. Assuming the config will not be changed in the server-runtime, I use singleton for TierConfig by Spring @Component.

Assuming for the UI, there is just only calculation result show on the page. But for the calculation details, you can find in the console or the log file.

## HOW LONG DID TAKE
1 days

## QUALITY APPROACH
Using abstract method factory design pattern to create data list of Transaction by different claim ways.

Using strategy design pattern to do the calculation by different claim ways.

DefaultExceptionHandler is used to handle different exceptions, which class should be maintain as projects go.

##