package ENUM_Usage_Examples.EnumSet_Usage_Example;

import java.util.EnumSet;
import static ENUM_Usage_Examples.EnumSet_Usage_Example.BodyParts.*;

public class EnumSet_Usage {
    public static void main(String[] args) {
        //Create empty EnumSet associated with specific Enum type(BodyParts)
        EnumSet<BodyParts> enumSet = EnumSet.noneOf(BodyParts.class);
        System.out.println(enumSet);

        //Add one od enum's values to EnumSet
        enumSet.add(HEAD);
        System.out.println(enumSet);

        //Add collection of some enum values
        enumSet.addAll(EnumSet.of(LEFT_HAND, RIGHT_LEG));
        System.out.println(enumSet);

        //Add to enumSet all the values from specific Enum(BodyParts)
        enumSet.addAll(EnumSet.allOf(BodyParts.class));
        System.out.println(enumSet);

        //Remove from enumSet the enum's values at specific range
        enumSet.removeAll(EnumSet.range(HEAD, NECK));
        System.out.println(enumSet);

        //Assign to enumSet the values that will complement the argument's enum to full list of it's values
        enumSet = EnumSet.complementOf(enumSet);
        System.out.println(enumSet);

    }
}
