import java.util.Objects;

public class Client {

    private String nom;
    private int priorite;

    public Client(String nom) {
        this.nom = nom;
        this.priorite = 3;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return priorite == client.priorite && Objects.equals(nom, client.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, priorite);
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", priorite=" + priorite +
                '}';
    }
}
