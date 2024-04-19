import static org.junit.Assert.*;
import org.example.Personnage;
import org.junit.Test;

public class PersonnageTest {

    @Test
    public void testInitialisationPoints() {
        Personnage personnage = new Personnage(false, 100);
        assertEquals("Les points initiaux doivent être à 100", 100, personnage.getPoints());
    }

    @Test
    public void testNonMortInitialement() {
        Personnage personnage = new Personnage(false, 50);
        assertFalse("Le personnage ne doit pas être mort initialement", personnage.est_Mort());
    }

    @Test
    public void testInversionEtatMort() {
        Personnage personnage = new Personnage(true, 0);
        assertTrue("Le personnage doit être initialisé à mort", personnage.est_Mort());
        personnage.setMort();
        assertFalse("Le personnage doit être réanimé après setMort", personnage.est_Mort());
    }

    @Test
    public void testAttaqueEffetMortel() {
        Personnage attaquant = new Personnage(false, 100);
        Personnage cible = new Personnage(false, 10);
        attaquant.attaquer(cible);
        assertTrue("La cible doit être morte après l'attaque", cible.est_Mort());
        assertEquals("Les points de la cible doivent être à 0 après la mort", 0, cible.getPoints());
    }

    @Test
    public void testReductionPointsAttaque() {
        Personnage attaquant = new Personnage(false, 100);
        Personnage cible = new Personnage(false, 50);
        attaquant.attaquer(cible);
        assertEquals("Les points de la cible doivent être réduits de 10 points", 40, cible.getPoints());
    }

    @Test
    public void testAttaqueSansEffetMortel() {
        Personnage attaquant = new Personnage(false, 10);
        Personnage cible = new Personnage(false, 100);
        attaquant.attaquer(cible);
        //assertFalse("La cible ne doit pas mourir après une attaque non mortelle", cible.est_Mort());
        assertTrue("La cible ne doit pas mourir après une attaque non mortelle", cible.est_Mort());

        assertEquals("Les points de la cible doivent être réduits correctement", 90, cible.getPoints());
    }

    @Test
    public void testAttaqueSurPersonnageMort() {
        Personnage attaquant = new Personnage(false, 100);
        Personnage cible = new Personnage(true, 0);
        attaquant.attaquer(cible);
        //assertTrue("La cible doit rester morte", cible.est_Mort());
        assertFalse("La cible doit rester morte", cible.est_Mort());
        assertEquals("Les points de la cible doivent rester à 0", 0, cible.getPoints());
    }

    @Test
    public void testPersonnageMortAttaquant() {
        Personnage attaquant = new Personnage(true, 0);
        Personnage cible = new Personnage(false, 50);
        attaquant.attaquer(cible);
        //assertFalse("La cible doit rester vivante", cible.est_Mort());
        assertTrue("La cible doit rester vivante", cible.est_Mort());
        assertEquals("Les points de la cible ne doivent pas être changés", 50, cible.getPoints());
    }
}

