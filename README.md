# 7CCSMPRJ Educational games for GCSE maths
The whole platform uses the IntelliJ idea, developed by Springboot integrating Thymeleaf, and PostgreSQL manages the back-end database. 
The whole system mainly realizes two parts: mathematical question answering and a two-person number filling game and provides answer scoring, grading, ranking, answer feedback, and corresponding user management functions.
#### Use guide
This system is based on the web application developed under the Springboot framework. At present, this systerm is still a development prototype. To run this project, people must import this file into the IntelliJ Idea development environment and start the **finalprojectapplication.java**  in the Java folder under the SRC folder. The back-end database of this project adopts the PostgreSQL database. The specific design of its database is described in the dissertation report. Before startup, a link with the database is established locally, and its configuration information is in **application.properties** under the Resources folder. Users can modify the user name and password of the local database to link. 
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
### SQL generator code
``` sql
create sequence users_id_seq
    as integer;

alter sequence users_id_seq owner to postgres;

create sequence levelsecond_lid_seq
    as integer;

alter sequence levelsecond_lid_seq owner to postgres;

create sequence table_name_tid_seq
    as integer;

alter sequence table_name_tid_seq owner to postgres;

create table "user"
(
    id       integer default nextval('users_id_seq'::regclass) not null
        constraint users_pk
            primary key,
    name     varchar(20)                                       not null,
    password varchar(8)                                        not null,
    level    integer                                           not null,
    age      integer                                           not null,
    email    varchar(30)                                       not null
);

alter table "user"
    owner to postgres;

alter sequence users_id_seq owned by "user".id;

create unique index users_id_uindex
    on "user" (id);

create unique index users_email_uindex
    on "user" (email);

create unique index user_name_uindex
    on "user" (name);

create table score
(
    sid   varchar not null
        constraint score_pk
            primary key,
    score integer,
    level integer not null,
    uid   integer not null
        constraint score_user_id_fk
            references "user",
    times integer not null
);

alter table score
    owner to postgres;

create unique index score_sid_uindex
    on score (sid);

create table level1
(
    lid      serial
        constraint level1_pk
            primary key,
    question varchar    not null,
    a        varchar    not null,
    b        varchar    not null,
    c        varchar    not null,
    d        varchar    not null,
    answer   varchar(1) not null
);

alter table level1
    owner to postgres;

create unique index level1_lid_uindex
    on level1 (lid);

create table level2
(
    lid      serial
        constraint level2_pk
            primary key,
    question varchar    not null,
    a        varchar    not null,
    b        varchar    not null,
    c        varchar    not null,
    d        varchar    not null,
    answer   varchar(1) not null
);

alter table level2
    owner to postgres;

create unique index level2_lid_uindex
    on level2 (lid);

create table level3
(
    lid      integer default nextval('levelsecond_lid_seq'::regclass) not null
        constraint levelsecond_pk
            primary key,
    question varchar                                                  not null,
    a        varchar                                                  not null,
    b        varchar                                                  not null,
    c        varchar                                                  not null,
    d        varchar                                                  not null,
    answer   varchar(1)                                               not null
);

alter table level3
    owner to postgres;

alter sequence levelsecond_lid_seq owned by level3.lid;

create unique index levelsecond_lid_uindex
    on level3 (lid);

create table level4
(
    lid      serial
        constraint level4_pk
            primary key,
    question varchar    not null,
    a        varchar    not null,
    b        varchar    not null,
    c        varchar    not null,
    d        varchar    not null,
    answer   varchar(1) not null
);

alter table level4
    owner to postgres;

create unique index level4_lid_uindex
    on level4 (lid);

create table level5
(
    lid      serial
        constraint level5_pk
            primary key,
    question varchar    not null,
    a        varchar    not null,
    b        varchar    not null,
    c        varchar    not null,
    d        varchar    not null,
    answer   varchar(1) not null
);

alter table level5
    owner to postgres;

create unique index level5_lid_uindex
    on level5 (lid);

create table level6
(
    lid      serial
        constraint level6_pk
            primary key,
    question varchar    not null,
    a        varchar    not null,
    b        varchar    not null,
    c        varchar    not null,
    d        varchar    not null,
    answer   varchar(1) not null
);

alter table level6
    owner to postgres;

create unique index level6_lid_uindex
    on level6 (lid);

create table current
(
    cid    serial
        constraint current_pk
            primary key,
    level  integer not null,
    lid    integer not null,
    uid    integer not null
        constraint current_user_id_fk
            references "user",
    answer varchar not null
);

alter table current
    owner to postgres;

create unique index current_cid_uindex
    on current (cid);

create table times
(
    tid     integer default nextval('table_name_tid_seq'::regclass) not null
        constraint times_pk
            primary key,
    uid     integer                                                 not null
        constraint table_name_user_id_fk
            references "user",
    begin   timestamp,
    endtime timestamp
);

alter table times
    owner to postgres;

alter sequence table_name_tid_seq owned by times.tid;

create unique index table_name_tid_uindex
    on times (tid);

create table game
(
    current  integer,
    gid      serial
        constraint game_pk
            primary key,
    restrain integer not null,
    level    integer not null
);

alter table game
    owner to postgres;

create unique index game_gid_uindex
    on game (gid);

create table operators
(
    oid      serial
        constraint operators_pk
            primary key,
    position integer not null,
    types    varchar not null,
    gid      integer not null
        constraint operators_game_gid_fk
            references game
);

alter table operators
    owner to postgres;

create unique index operators_oid_uindex
    on operators (oid);

create table numbers
(
    nid    serial
        constraint numbers_pk
            primary key,
    gid    integer not null,
    figure integer not null,
    status integer not null
);

alter table numbers
    owner to postgres;

create unique index numbers_nid_uindex
    on numbers (nid);

create table choose
(
    cid      serial
        constraint choose_pk
            primary key,
    figure   integer not null,
    position integer not null,
    gid      integer not null
        constraint choose_game_gid_fk
            references game,
    nid      integer not null
        constraint choose_numbers_nid_fk
            references numbers
);

alter table choose
    owner to postgres;

create unique index choose_cid_uindex
    on choose (cid);

create table record
(
    rid      serial
        constraint record_pk
            primary key,
    uid      integer not null
        constraint record_user_id_fk
            references "user",
    level    integer not null,
    lid      integer not null,
    question varchar not null,
    answer   varchar not null,
    correct  integer not null
);

alter table record
    owner to postgres;

create unique index record_rid_uindex
    on record (rid);

```
