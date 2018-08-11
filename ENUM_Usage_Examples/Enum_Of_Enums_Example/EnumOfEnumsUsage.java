package ENUM_Usage_Examples.Enum_Of_Enums_Example;

import java.util.Random;

public class EnumOfEnumsUsage {
    private static Random rand = new Random();

    public static void main(String[] args) {
        for (int i=0; i<5 ; i++)
        {
            for (EnumOfEnums foodCategoryEnum : EnumOfEnums.values())   //iterating over Food categories like "Appetizer, Dessert"
            {
                Food food = getRandomFood(foodCategoryEnum.getValues());
                System.out.println(food);
            }

            System.out.println("----------------");
        }
    }

    private static Food getRandomFood(Food[] values)
    {
        return values[rand.nextInt(values.length)];
    }
}
