package ENUM_Usage_Examples.Inteface_Implementation_By_Enum;

import java.util.Random;

public enum CartoonCharacter implements Generator<CartoonCharacter>{
    DIESEL, SMITH, WILLIS, DICAPRIO;

    @Override
    public CartoonCharacter next() {
        Random rand = new Random();
        return CartoonCharacter.values()[rand.nextInt(CartoonCharacter.values().length)];
    }
}

