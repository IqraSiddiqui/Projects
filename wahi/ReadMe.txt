
Overview:
    WAHI is a voice assistant that is connected to a database wahi. It has the capability to retrive query from wahi database and execute various other instructions on voice commands.List of instructions that wahi can respond to is provided below. WAHI implements factory design patter to generate a TaskFactory for various task and perform them correspondingly.

-----------------------------
How to compile?
javac -cp ".;./lib/cmu_us_kal.jar.;./lib/cmu_us_kal.jar.;./lib/mysql-connector-java-8.0.26.jar.;./lib/cmulex.jar.;./lib/cmutimelex.jar.;./lib/en_us.jar.;./lib/freetts.jar.;./lib/freetts-jsapi10.jar.;./lib/sphinx4-core-5prealpha-20160628.232526-10.jar.;./lib/sphinx4-data-5prealpha-20160628.232535-10.jar.;./lib/cmu_time_awb.jar.;./lib/mbrola.jar" --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media ./Main.java

---------------------------------

How to execute?
java -cp ".;./lib/cmu_us_kal.jar.;./lib/cmu_us_kal.jar.;./lib/mysql-connector-java-8.0.26.jar.;./lib/cmulex.jar.;./lib/cmutimelex.jar.;./lib/en_us.jar.;./lib/freetts.jar.;./lib/freetts-jsapi10.jar.;./lib/sphinx4-core-5prealpha-20160628.232526-10.jar.;./lib/sphinx4-data-5prealpha-20160628.232535-10.jar.;./lib/cmu_time_awb.jar.;./lib/mbrola.jar" --module-path 'C:\javafx-sdk-17.0.1\lib' --add-modules javafx.controls,javafx.fxml,javafx.media Main

---------------------------------

Credentials to Log in

userName: admin
Password: ok

---------------------------------
Instructions WAHI can understand:
-----------------------------

-Greetings
wake up
who are you
good morning
sleep

-chatting
start chatting

-Retrieving data from tables
0 //select * from grocessory_lst table
1 //select * from grocessory_lst where price > 10
2 //select * from wahi_commands i.e. to display all commands that wahi can understand


-For opening local applications:
open chrome
open microsoft edge
open word
open excel
open power point
open paint
open command prompt
open control panel
open calculator
open player
open notepad
open file manager

-For closing local applications:
close chrome
close microsoft edge
close word
close excel
close power point
close paint
close command prompt
close control panel
close calculator
close player
close notepad
close file manager

-For opening internet site
open youtube
open google
open lms
open pscs
open outlook
