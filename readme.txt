Restaurant Reservation System ( Mohab Mahmoud 6208 )   ( Moataz Mohamed 6210 )
------------------------------------------------------------------------------

First you login using valid Username and Password from the givn .xml file
if the username and password are incorret you get error message
after you Login the program moves you to the correct dashboard according to your role ( Manager - Cooker - Waiter - Client)
and from that dashboard you can do the activity required 

Managers can 
=============
      1.View all users
      2.View Dishes
      3.View Today's Reservation and who is coming to the restaurant
      4.Calculate total earnings for the day.


Cookers can
============
      1.View Dishes
      2.View Resrvations


Waiters can
============
      1.View Reservations


Clients can
============
      1.View Dishes
      2.Add a reservation

Adding Reservation Method
=========================
  The client will login and then press the button ("Add Reservation") , then he will be moved to Reservations screen where he will find 
  3 choiceboxes , 1 for each type of the dish (appetizer , Main course , dessert) he will choose whatever he wants and then press record 
  he can add more dishes as he likes by pressing the button ("Record") then he will choose a table from the tables shown according to
  what suits him , after choosing the table he will press the Button choose . Before pressing save he has to press to calculate button
  to see the amount of money he will pay after adding the taxes , if he wants to cancel the order just press cancel , if he wants to save
  he will press save.

Saving Method
=============
  Due to errors when saving a reservation without the saved.xml file or with it being empty , we had to initially create an empty field within
  in order to run the program at first , that's why the reservations table has an empty row with 0 price and 0 number.


Running the program
===================
  we created the self-executable jar file as shown in the tutorial but it didn't run after double clicking it , so as mentioned by engineer
  Merna we made a .bat file to run the jar from, it's in the main program folder named as Restaurant_Reservation_System .

-----------------
Labour Division
-----------------
(Mohab Mahmoud 6208)
  1.GUI Designing and Coding
  2."restaurant" package
  3.Inheritance and methods
  4.Login Validation



(Moataz Mohamed 6210)
  1.Load the given XML file
  2.Save the Client's order with his name and all the data
  3.new XML file classes "reservedRestaurant" package
  3.Reservation Logic
  4.UML

