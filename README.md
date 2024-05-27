# Tennis score computer

A Spring Boot based program that provides a simple tennis score computer.

### Scoring rules description

---

This Kata goal is to implement a simple tennis score computer.

The scoring system consist in one game, divided by points :

- Each player starts a game with 0 point.

- If the player wins the 1st ball, he will have 15 points. 2nd balls won 30 points and 3rd ball won 40points.

- If a player have 40 points and wins the ball, he wins the game, however there are special rules:

    - If both players have 40 points the players are "deuce".

    - If the game is in deuce, the winner of the ball will have advantage.
        - If the player with advantage wins the ball he wins the game.
        - If the player without advantage wins the ball they are back at "deuce".

You can found more details about the rules here : ( http://en.wikipedia.org/wiki/Tennis#Scoring )

### Computer input/output format

---
The computer takes a String as input containing the character 'A' or 'B'. The
character 'A' corresponding to "player A won the ball", and 'B' corresponding to "player B won the ball".
The computer print the score after each won ball (for example : "Player A : 15 / Player B : 30") and print the winner of
the game.

For example the following input "ABABAA" will print :

```
"Player A : 15 / Player B : 0"
"Player A : 15 / Player B : 15"
"Player A : 30 / Player B : 15"
"Player A : 30 / Player B : 30"
"Player A : 40 / Player B : 30"
"Player A wins the game"
```

### Required environment

---

* Java 21
* Maven 3.9.2
* Spring Boot Starter 3.2.5
* maven-jar-plugin 3.13.0

### Launch computer

---

1. Run in IntelliJ

    - Run TennisScoreComputer class with input String parameter

2. Run by jar

```
mvn clean package
```

Get jar in target folder.

```
java -jar TennisScoreComputer-0.0.1-SNAPSHOT.jar %input_string%
```

### Potential evolution

---

The first version is not included the following potential evolutions:

- Unit test coverage rate to be improved
- Output evolution to stock information in files
- BDD can be added to control behaviors with scenarios
- ...

### Used information

---

* [Maven](https://maven.apache.org/)
* [Spring Boot](https://docs.spring.io/spring-boot/index.html)
* [Hexagonal architecture](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))
* [Visitor behavioral design pattern](https://en.wikipedia.org/wiki/Visitor_pattern)
* [State behavioral design pattern](https://en.wikipedia.org/wiki/State_pattern)

### License

---

TennisScoreComputer is Open Source released under
the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.html).

### From author

---

Please do not hesitate to leave comments or fork it to add evolutions :)