import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        TicketsSystem system = new TicketsSystem();

        for (int i = 0; i < 100; i++){
            int num = random.nextInt(100);
            String number = Integer.toHexString(num+1);
            Id currenrId = system.getId(number);

        }

    }
}