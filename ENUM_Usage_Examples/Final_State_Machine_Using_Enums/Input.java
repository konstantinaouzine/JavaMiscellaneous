package ENUM_Usage_Examples.Final_State_Machine_Using_Enums;

import java.util.Random;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount(){ // Not allowed
            throw new RuntimeException("Abort.amount()");
        }
    },
    STOP {
        public int amount(){ //Not allowed
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;  // In cents
    //Constructors
    Input(int value) {
        this.value = value;
    }
    Input(){}  //Empty constructor

    //amount() will be called for the selection to understand, whether we have enough money inserted to pay for the selection or not
    //amount() also will be called DISPENSING state in order to deduct the selection price from our current balance
    int amount() {
        return this.value;
    }

    static Random rand = new Random();
    public static Input randomSelection(){
        //Excluding "STOP"
        return values()[rand.nextInt(values().length -1)];
    }
}
