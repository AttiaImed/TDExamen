import java.util.Comparator;

public class TriCode implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return Integer.compare(o1.getCode(),o2.getCode());
    }

}
