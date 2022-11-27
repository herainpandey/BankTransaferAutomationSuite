package workflowHelper;

import java.util.Random;

public class Helper {

    public static String generateRandomAccount(){
        Random rand = new Random();
        int num = rand.nextInt(90000) + 10000;
        return String.valueOf(num);
    }


    public static String generateRandomTransactionAmount(){
        Random rand = new Random();
        int num = rand.nextInt(900) + 100;
        return String.valueOf(num);

    }

    public static String generateRandomSSNNumber(){
        Random rand = new Random();
        int num = rand.nextInt(900000000) + 100000000;
        return String.valueOf(num);

    }
}
