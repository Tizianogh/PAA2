package EXERCICE3;

public class Main {

    public static void main(String[] args) {
        Magasin<Article> m = new Magasin<>(5);
        Course c = new Course(m);
        Course c2 = new Course(m);
        Course c3 = new Course(m);
        Course c4 = new Course(m);
        Course c5 = new Course(m);
        Fournisseur f = new Fournisseur("Poulet",m);
        Fournisseur f2 = new Fournisseur("Rat",m);
        Fournisseur f3 = new Fournisseur("Chien",m);
    }
}
