package ENUM_Usage_Examples.States;

import static ENUM_Usage_Examples.States.US_States.*;

public class State_Enum_Usage {

    US_States state;

    State_Enum_Usage(US_States state)
    {
        this.state = state;
    }

    public static void main(String[] args) {
        US_States state1 = US_States.getStateViaName("ALASKA");
        US_States state2 = US_States.getStateViaAbbreviation("TX");
        US_States state3 = Enum.valueOf(US_States.class, "NEW_YORK");
        System.out.println(state1);
        System.out.println(state2);
        System.out.println(state3);
        State_Enum_Usage test1 = new State_Enum_Usage(NEW_YORK);  //Enum values imported statically -
                                                                    // no need to specify the Enum class
        System.out.println(US_States.values().length);
    }
}
