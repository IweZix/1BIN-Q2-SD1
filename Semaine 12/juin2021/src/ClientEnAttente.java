public class ClientEnAttente {

    private String nom;
    private int priorite;

    public ClientEnAttente(String nom) {
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
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", priorite=" + priorite +
                '}';
    }
}
