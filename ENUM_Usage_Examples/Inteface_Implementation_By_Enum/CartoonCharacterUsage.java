package ENUM_Usage_Examples.Inteface_Implementation_By_Enum;

public class CartoonCharacterUsage {

    static <T> void printNext(Generator<T> generator)
    {
        System.out.println(generator.next());
    }

    public static void main(String[] args) {
        CartoonCharacter cartoonCharacter = CartoonCharacter.DIESEL;
        for (int i=0; i<5; i++)
        {
            printNext(cartoonCharacter);
        }
    }
}
