# Dealer
`Dealer` is a simulation of a Texas Hold 'Em game. Upon running, an eight-person
Texas Hold 'Em game will be dealt, with game status printed to the screen.

Example execution:
```
$ java -jar Dealer.jar
You are Player #0.
There are 8 player(s) total.

New Round:
  You are the dealer.

Press <Enter> to continue.

Deal:
  Your hand:
    Queen of Diamonds
    3 of Hearts
Press <Enter> to continue.

Flop:
  10 of Spades
  5 of Hearts
  8 of Clubs
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
