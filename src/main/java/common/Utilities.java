package common;

import java.util.Random;

public class Utilities {
    public static Integer randomNumber(){
        Random rand = new Random();
        return rand.nextInt(999999);
    }
}
