package ENUM_Usage_Examples.Final_State_Machine_Using_Enums;

public class VendingMachine {
    private static State state = State.RESTING;
    private static int balance = 0;
    private static Input selection = null;
    private static boolean isPurchased = false;
    enum StateDuration { TRANSIENT }
    enum State {
        RESTING {
            void next(Input input) {
               switch(Category.categorize(input)){
                   case MONEY:
                       balance +=input.amount();
                       System.out.print("First deposit: ") ; state.output();
                       state = ADDING_MONEY;
                       break;
                   case SHUT_DOWN:
                       state = TERMINATE;
                   default:
               }
            }
        },
        ADDING_MONEY {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        balance += input.amount();
                        System.out.println("Added - " + input.amount() + ", Current - " + balance);
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (balance < selection.amount())
                            System.out.println("Insufficient money for " + selection + "(" + selection.amount() + ")");
                        else
                            state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINATE;
                    default:
                }
            }
        },
        DISPENSING (StateDuration.TRANSIENT){
            void next() {
                System.out.print("Here is your " + selection);
                balance -= selection.amount();
                isPurchased = true;
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE (StateDuration.TRANSIENT) {
            void next() {
                if (balance > 0) {
                    if (isPurchased)
                        System.out.println(" and your change: " + balance);
                    else
                        System.out.println("Withdrawn: " + balance);
                    balance = 0;
                    isPurchased = false;
                    state = RESTING;
                }
                else
                    //state = RESTING;
                {
                    System.out.println("No change to give, terminating");
                    state = TERMINATE;
                }
            }
        },
        TERMINATE {
            void output() {
                System.out.println("HALTED");
            }
        };

        private boolean isTransient = false;

        //Constructors
        State() {}
        State(StateDuration trans) {isTransient = true;}

        void next() {
            throw new RuntimeException("Call next() only for StateDuration.TRANSIENT states");
        }
        void next(Input input){
            throw new RuntimeException("Call next(Input input) only for non-transient states");
        }

        void output() {
            System.out.println(balance);
        }

        static void run() {
            while (state != State.TERMINATE)
            {
                state.next(Input.randomSelection());
                while (state.isTransient)
                {
                    state.next();
                }
                //state.output();
            }
        }

        public static void main(String[] args) {
            run();
        }
    }
}
