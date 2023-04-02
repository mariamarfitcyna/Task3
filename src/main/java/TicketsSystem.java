import java.util.HashMap;
import java.util.Random;

public class TicketsSystem {

    private HashMap<String, Id> tickets;

    public TicketsSystem(){
        tickets = new HashMap<>();
        buyTickets();
    }

    public static Id getRandomId(){
        Random random = new Random();
        Id[] options = Id.values();
        int size = Id.values().length;
        return options[random.nextInt(size)];
    }

    private void buyTickets(){

        for (int i = 0; i < 100; i++){
            String hexNumber = Integer.toHexString(i+1);
            Id id = getRandomId();
            this.tickets.put(hexNumber, id);
        }
    }

    public Id getId(String key){
        return this.tickets.get(key);
    }
}
