package ENUM_Usage_Examples.Rock_Paper_Scissors_Using_Enums;

import java.util.Random;

import static ENUM_Usage_Examples.Rock_Paper_Scissors_Using_Enums.Outcome.*;

public enum Roshambo {
    ROCK     (DRAW, WIN, LOSE),
    SCISSORS (LOSE, DRAW, WIN),
    PAPER    (WIN, LOSE, DRAW);

    private Outcome vRock, vScissors, vPaper;
    private static Random rand = new Random();

    Roshambo(Outcome rock, Outcome scissors, Outcome paper){
        this.vPaper = paper;
        this.vScissors = scissors;
        this.vRock = rock;
    }

    public Outcome compete(Roshambo competitor) {
        switch (competitor){
            default:
            case PAPER: return vPaper;
            case SCISSORS: return vScissors;
            case ROCK: return vRock;
        }
    }

    public static Roshambo getRandomRoshambo() {
        switch (rand.nextInt(3))
        {
            default:
            case 0: return PAPER;
            case 1: return SCISSORS;
            case 2: return ROCK;
        }
    }
}
