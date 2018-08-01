# Dealer
`Dealer` is a simulation of a Texas Hold 'Em game. Upon running, an eight-person
Texas Hold 'Em game will be dealt, with game status printed to the screen.

Example execution:
```
$ java -jar Dealer.jar
==================== NEW ROUND ====================

You are Player #0.
There are 8 player(s) total.

You are the dealer.

Your hand:
  6 of Diamonds
  10 of Diamonds
Press <Enter> to continue.

Flop:
  7 of Hearts
  9 of Spades
  8 of Spades
Press <Enter> to continue.
...
```

Note that the simulation is display-only; no interaction with the user is
performed.

---

## Build
The build process is implemented using [Apache Ant](https://ant.apache.org/). To
build, use the following command:

`$ ant jar`

## Run
Ant can be used to run as well:

`$ ant run`

Alternatively, the JAR file can be run directly:

`$ cd dist/ && java -jar Dealer.jar`
