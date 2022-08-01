# 7CCSMPRJ Educational games for GCSE maths
The whole platform uses the IntelliJ idea, developed by Springboot integrating Thymeleaf, and PostgreSQL manages the back-end database. 
The whole system mainly realizes two parts: mathematical question answering and a two-person number filling game and provides answer scoring, grading, ranking, answer feedback, and corresponding user management functions.
#### Use guide
This system is based on the web application developed under the Springboot framework. At present, this systerm is still a development prototype. To run this project, people must import this file into the IntelliJ Idea development environment and start the ** finalprojectapplication.java**  in the Java folder under the SRC folder. The back-end database of this project adopts the PostgreSQL database. The specific design of its database is described in the dissertation report. Before startup, a link with the database is established locally, and its configuration information is in ** application.properties** under the Resources folder. Users can modify the user name and password of the local database to link. 
After running the system, access http://localhost:8080/login to use this system.

This project main part is src file and the project is structured as follows.
```
src:.
│  
├─main
│  ├─java
│  │  └─com
│  │      └─example
│  │          └─finalproject
│  │              │  FinalProjectApplication.java
│  │              │  
│  │              ├─config
│  │              │      loginConfig.java
│  │              │      myMvcConfig.java
│  │              │      
│  │              ├─controller
│  │              │      currentController.java
│  │              │      detailController.java
│  │              │      gameController.java
│  │              │      levelController.java
│  │              │      pageController.java
│  │              │      personaInfoController.java
│  │              │      scoreController.java
│  │              │      userController.java
│  │              │      
│  │              ├─dao
│  │              │      chooseDao.java
│  │              │      currentDao.java
│  │              │      gameDao.java
│  │              │      level1Dao.java
│  │              │      level2Dao.java
│  │              │      level3Dao.java
│  │              │      level4Dao.java
│  │              │      level5Dao.java
│  │              │      level6Dao.java
│  │              │      numbersDao.java
│  │              │      operatorsDao.java
│  │              │      recordDao.java
│  │              │      scoreDao.java
│  │              │      timesDao.java
│  │              │      userDao.java
│  │              │      
│  │              ├─entity
│  │              │      choose.java
│  │              │      current.java
│  │              │      game.java
│  │              │      level1.java
│  │              │      level2.java
│  │              │      level3.java
│  │              │      level4.java
│  │              │      level5.java
│  │              │      level6.java
│  │              │      numbers.java
│  │              │      operators.java
│  │              │      record.java
│  │              │      score.java
│  │              │      times.java
│  │              │      user.java
│  │              │      
│  │              └─service
│  │                      chooseService.java
│  │                      chooseServiceIml.java
│  │                      currentService.java
│  │                      currentServiceIml.java
│  │                      gameService.java
│  │                      gameServiceIml.java
│  │                      l2Service.java
│  │                      l2ServiceIml.java
│  │                      l3ServcieIml.java
│  │                      l3Service.java
│  │                      l4Service.java
│  │                      l4ServiceIml.java
│  │                      l5Service.java
│  │                      l5ServiceIml.java
│  │                      l6Service.java
│  │                      l6ServiceIml.java
│  │                      level1Service.java
│  │                      level1ServiceIml.java
│  │                      loginService.java
│  │                      loginServiceIml.java
│  │                      numberService.java
│  │                      numberServiceIml.java
│  │                      operatorsService.java
│  │                      operatorsServiceIml.java
│  │                      recordService.java
│  │                      recordServiceIml.java
│  │                      scoreService.java
│  │                      scoreServiceIml.java
│  │                      timesService.java
│  │                      timesServiceIml.java
│  │                      userService.java
│  │                      userServiceIml.java
│  │                      
│  └─resources
│      │  application.properties
│      │  
│      ├─static
│      │  ├─css
│      │  │      index.css
│      │  │      register.css
│      │  │      
│      │  └─images
│      │          bg.jpg
│      │          
│      └─templates
│          │  chart.html
│          │  detail.html
│          │  feedback.html
│          │  gameBegin.html
│          │  index.html
│          │  judge.html
│          │  level.html
│          │  login.html
│          │  lose.html
│          │  personalPage.html
│          │  question2.html
│          │  question3.html
│          │  question4.html
│          │  question5.html
│          │  question6.html
│          │  questions.html
│          │  rank.html
│          │  rankchoose.html
│          │  register.html
│          │  showQuestion.html
│          │  sucess.html
│          │  
│          └─error
│                  404.html
│                  500.html
│                  
└─test
    └─java
        └─com
            └─example
                └─finalproject
                        FinalProjectApplicationTests.java
```
