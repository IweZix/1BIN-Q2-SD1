import java.util.Comparator;

public class ComparateurClient implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        if (o1.getPriorite() < o2.getPriorite())
            return 1;
        if (o1.getPriorite() > o2.getPriorite())
            return -1;
        return 0;
    }
}