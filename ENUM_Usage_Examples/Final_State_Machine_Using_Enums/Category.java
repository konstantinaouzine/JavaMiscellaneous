package ENUM_Usage_Examples.Final_State_Machine_Using_Enums;
import java.util.EnumMap;

import static ENUM_Usage_Examples.Final_State_Machine_Using_Enums.Input.*;

public enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] values;
    //Constructor
    Category(Input... types){
        this.values = types;
    }

    private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);

    static{
        for (Category c : Category.class.getEnumConstants()) {
            for (Input input : c.values) {
                categories.put(input, c);
            }
        }
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
