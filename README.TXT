Application to read data from STDIN and join users by emails

Building process:
1) load data in some folder "IntterraTest"
2) Check maven version: "mvn --version" (I used version 3.6.2)
3) Check java version: "java --version" ( 1.8 and later)
4) change dir to IntterraTest
5) call "mvn package"
6) jar file will be built in "target" folder: "userJoin-0.1.jar".

Application call:
1) Call: "java -jar userJoin-0.1.jar"
2) First at line you pass number of input rows:
3) Then pass all rows in format:
   "user -> email1, email2, email3"

Result will be presented into output in the same format

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

