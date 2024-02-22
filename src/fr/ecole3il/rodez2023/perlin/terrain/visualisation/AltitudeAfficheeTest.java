package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AltitudeAfficheeTest {

    @Test
    public void testDeterminerAltitudeAfficheeFondMarin() {
        // Arrange
        double altitude = -0.5; // Une valeur négative quelconque

        // Act
        AltitudeAffichee resultat = AltitudeAffichee.determinerAltitudeAffichee(altitude);

        // Assert
        assertEquals(AltitudeAffichee.FOND_MARIN, resultat); // Le résultat doit être FOND_MARIN
    }
}
