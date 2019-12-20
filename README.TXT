Application to read data from STDIN and join users by emails

Building process:
2) Check git installed. "git version". If not install
2) Check maven version: "mvn --version" (I used version 3.6.2)
3) Check java version: "java --version" ( 1.8 and later)
4) load data in some folder i.e. "IntterraTest" (git clone https://github.com/jabbowsky/IntterraTest.git);
5) change dir to IntterraTest
6) call "mvn package"
7) jar file will be built in "target" folder: "userJoin-0.1.jar"

Application call:
1) Call: "java -jar userJoin-0.1.jar"
2) First at line you pass number of input rows
3) Then pass all rows in format:
   "user -> email1, email2, email3"
   "user2 -> email3, email5, email4"
4) Result will be presented into output in the same format:
  "user -> email1, email2, email3, email5, email4"


Example:

\> java -jar userJoin-0.1.jar
5
5 cases to enter:
user1 -> xxx@ya.ru, foo@gmail.com, lol@mail.ru
user2 -> foo@gmail.com, ups@pisem.net
user3 -> xyz@pisem.net, vasya@pupkin.com
user4 -> ups@pisem.net, aaa@bbb.ru
user5 -> xyz@pisem.net
Output
user3 -> vasya@pupkin.com, xyz@pisem.net
user1 -> aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com

