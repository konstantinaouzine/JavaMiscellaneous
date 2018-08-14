package ENUM_Usage_Examples.Chain_Of_Responsibility_Using_Enums;


public class HR {
    enum CVHandler {
        Process_VIA_TECH_STACK {
            boolean handle(CV cv){
                switch (cv.technologiesStackKnown){
                    case YES:
                        System.out.println("accepted because of good tech stack.");
                        return true;
                    default:
                        switch (cv.yearsOfExp){
                            case MORE_THEN_7:
                            case FIVE:
                            case FOUR:
                                System.out.println("accepted because of years of experience.");
                                return true;
                            case JUNIOR:
                            default:
                                return false;
                        }
                }
            }
        },
        PROCESS_VIA_PRIVATE_QUALITIES {
            boolean handle(CV cv){
                switch (cv.fastLerner){
                    case YES:
                        System.out.println("accepted because fast learner.");
                        return true;
                    default:
                        switch(cv.selfLearnJava){
                            case NO1:
                            case NO2:
                            case NO3:
                                return false;
                            case YES:
                            default:
                                System.out.println("accepted because learned JAVA at home.");
                                return true;
                        }

                }
            }
        };
        //abstract method should be added to enum in order to be able to call handle() method for enum instance
       abstract boolean handle(CV cv);
    }

    static void handle(CV cv)
    {
        for (CVHandler cvHandler : CVHandler.values())
        {
            //Attempt to handle the cv with all types of CVHandlers(enum's values) using chain of responsibilities pattern
            //Handlers called one by one until one of them would be able to handle the CV
            if (cvHandler.handle(cv))
                return;
        }
        System.out.println("Was not accepted to job");
    }

    public static void main(String[] args) {
        for (CV cv : CV.cvGenerator(10))
        {
            System.out.println(cv.details());
            handle(cv);
            System.out.println("---------------");
        }
    }
}
