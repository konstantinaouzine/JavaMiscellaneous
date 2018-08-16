package ENUM_Usage_Examples.Rock_Paper_Scissors_Using_Enums;

public class RoshamboTest {
    public static void match(Roshambo a, Roshambo b)
    {
        System.out.println(a + " " + a.compete(b) + " " + b);
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++)
        {
            match(Roshambo.getRandomRoshambo(), Roshambo.getRandomRoshambo());
        }
    }
}
