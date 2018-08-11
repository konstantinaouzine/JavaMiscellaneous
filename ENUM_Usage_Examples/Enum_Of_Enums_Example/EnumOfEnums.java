package ENUM_Usage_Examples.Enum_Of_Enums_Example;

public enum EnumOfEnums {
    APPETIZER(Food.Appetizer.class ),
    MAIN_DISH(Food.MainDish.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    EnumOfEnums(Class<? extends Food> foodKind){
        //if (foodKind!=null)
        values = foodKind.getEnumConstants();
    }

    public Food[] getValues() {
        return values;
    }
}
