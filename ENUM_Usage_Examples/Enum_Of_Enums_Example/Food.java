package ENUM_Usage_Examples.Enum_Of_Enums_Example;


//enum can't be inherited from another class because it extends Enum class.
// So in order to expand the enum values, we may group enums together under one interface and make them all implement this interface
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainDish implements Food{
        BURRITO, PAD_THAI, LENTILS;
    }

    enum Dessert implements Food{
        TIRAMISU, CAKE, FRUIT, CREAM_CARAMEL;
    }

    enum Coffee implements Food{
        ESPRESSO, LATTE, TEA, HERB_TEA;
    }

}
