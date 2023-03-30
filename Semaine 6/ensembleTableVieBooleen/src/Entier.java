public class Entier {

    private int entier;

    public Entier(int entier) {
        this.entier = entier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entier entier1 = (Entier) o;
        return entier == entier1.entier;
    }

    @Override
    public String toString() {
        return ""+entier;
    }

    @Override
    public int hashCode() {
        return entier;
    }
}
