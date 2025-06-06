import org.example.Voiture;
import org.example.service.Statistique;
import org.example.service.StatistiqueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    @Test
    public void  getTotalPriceAfterSale(){
        Statistique statistique = new StatistiqueImpl();

        statistique.ajouter(new Voiture("Fiat", 30000.00));
        statistique.ajouter(new Voiture("Mercedes CDI 220", 30000.00));
        statistique.ajouter(new Voiture("Renault 307 HDI", 30000.00));
        statistique.ajouter(new Voiture("Renault Megane 1", 30000.00));
        statistique.ajouter(new Voiture("Renault Clio 1", 30000.00));
        statistique.ajouter(new Voiture("Renault Clio 2", 30000.00));

        double prixTotalApresRemise = 0.00;
        try {
            prixTotalApresRemise = statistique.prix();
            Assertions.assertEquals(171000, prixTotalApresRemise);
        } catch (ArithmeticException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    public void  getTotalPriceAfterSaleOverLimit(){
        Statistique statistique = new StatistiqueImpl();

        statistique.ajouter(new Voiture("Fiat", 30000.00));
        statistique.ajouter(new Voiture("Mercedes CDI 220", 30000.00));
        statistique.ajouter(new Voiture("Renault 307 HDI", 30000.00));
        statistique.ajouter(new Voiture("Renault Megane 1", 30000.00));
        statistique.ajouter(new Voiture("Renault Clio 1", 30000.00));
        statistique.ajouter(new Voiture("Renault Clio 2", 30000.00));
        statistique.ajouter(new Voiture("Alph Romeo", 30000.00));
        statistique.ajouter(new Voiture("Renault Megane 2", 30000.00));
        statistique.ajouter(new Voiture("Citroen Picasso", 30000.00));
        statistique.ajouter(new Voiture("BMW Turbo", 30000.00));
        statistique.ajouter(new Voiture("Ferrari Sport", 30000.00));

        double prixTotalApresRemise = 0.00;
        try {
            prixTotalApresRemise = statistique.prix();
            Assertions.assertEquals(310000.00, prixTotalApresRemise);
        } catch (ArithmeticException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
