Hello!!

What is this project? 

At first my intention was to create a blog app. In order to make better use of RabbitMQ, i pushed a bit further. Now it looks like a mix of Twitter and Snapchat - just a tiny one. You can call it FakeBook :D

The user has a profile like personal url where he can share messages visible to everyone.
But unlike Twitter, there is only one message the user can post on his feed. Every post replaces the previous one, so it's like a status update, where you share only recent stuff. Of course the users previous messages are stored but not visible. Messages you share have Tag title, which is saved as "Interests" with help of RabbitMQ helper project, with the username in another database when you like a posted message.



Used Tech:  Java 11, Maven, Spring Boot, spring security jwt, Hibernate, H2 DB, RabbitMQ (Requires Erlang), Optional -> Docker


There's a Postman JSON collection file in the repository I highly recomend you to import to your Postman - Blog.postman_collection.json - There you can follow the steps.

Don't forget to mvn clean install

mvn spring-boot:run

If you have Docker configurations, it's compatible but that's optional. You only need H2 database and RabbitMQ to run the project. You can set your own options for localhost ports in "application.properties" or use mine:

- RabbitMQ port : 5672   <-- check status on http://localhost:15672 (you might need to create a new user with admin priviledges)

- Main H2 Database port : 8080   <-- check default page http://localhost:8080/h2-ui  (set your own username / password)

- Helper H2 Database port : 9000   <-- defaul page http://localhost:9000/h2-ui-interest  


![tables](https://user-images.githubusercontent.com/81401869/154841313-ca804dcd-d896-4131-ac3c-fb1b7f06c2d1.jpg)



--- How Does The App Work? ---

Before you start to use the app >> You will need Postman to create users and do actions << Please import Blog.postman_collection.json file from repository in your Postman Collections. 

The app has JWT, and 3 roles of users. When you signup a new user, you can define yourself as admin, moderator or user.  You can signin with username and password you created. There you will get a generated Cookie with JWT inside. Copy it or add to sync on Postman because you will need that token for most actions. Then you can send post message with "message context" and a "tag". You will get an auto generated messageId inside the response. Use that messageId to like or delete message.

When you like a message with messageId, the app records username, increases like count, adds your name to liked users list. At the same time, an event goes to helper project with RabbitMQ, username and liked tag gets saved in a seperate repository.

The app can be upgraded with on additions to the helper projects structure to create more detailed interest records, following users, or users own choice of interest. Main project can add new features like posting photos, videos and sound files.

I wish I had more time to continue this project but in future I definetely will. You can follow me I will keep this project in another repository.

 - Here's link of Main Project:

https://github.com/Patika-PayCore-BootCamp-Organization/hw-project-AerenN
