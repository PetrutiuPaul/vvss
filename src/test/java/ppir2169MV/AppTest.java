package ppir2169MV;

import org.junit.Test;
import ppir2169MV.control.BibliotecaCtrl;
import ppir2169MV.model.Carte;
import ppir2169MV.repository.repoInterfaces.CartiRepoInterface;
import ppir2169MV.repository.repoMock.CartiRepoMock;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    CartiRepoInterface cr = new CartiRepoMock();
    BibliotecaCtrl bc = new BibliotecaCtrl(cr);

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void TC1_ECP()
    {
        Carte c = new Carte();
        try {
            c.setTitlu("Ion");
            c.setAnAparitie("1919");
            c.adaugaReferent("Rebreanu");
            c.adaugaCuvantCheie("sapa");
            c.adaugaCuvantCheie("mort");

            bc.adaugaCarte(c);
        }catch (Exception ex){
            fail();
        }

        assertTrue( true );
    }

    @Test
    public void TC2_ECP()
    {
        Carte c = new Carte();
        try {
            c.setTitlu("Moara noroc");
            c.setAnAparitie("-1");
            c.adaugaReferent("Nimeni");
            c.adaugaCuvantCheie("doamne");

            c.adaugaCuvantCheie("ajuta");

            bc.adaugaCarte(c);

            fail();
        }catch (Exception ex){
            if(ex.getMessage().equals("Editura invalid!"))
                assertTrue(true);
            else
                fail();
        }
    }

    @Test
    public void TC3_ECP()
    {
        Carte c = new Carte();
        try {
            c.setTitlu("");
            c.setAnAparitie("2010");
            c.adaugaReferent("da");
            c.adaugaCuvantCheie("amin");

            bc.adaugaCarte(c);

            fail();
        }catch (Exception ex){
            if(ex.getMessage().equals("Titlu invalid!"))
                assertTrue(true);
            else
                fail();
        }
    }

    @Test
    public void TC4_ECP()
    {
        Carte c = new Carte();
        try {
            c.setTitlu("Moara ghinion");
            c.setAnAparitie("2010");
            c.adaugaReferent("2");
            c.adaugaCuvantCheie("amin");

            bc.adaugaCarte(c);

            fail();
        }catch (Exception ex){
            if(ex.getMessage().equals("Autor invalid!"))
                assertTrue(true);
            else
                fail();
        }
    }

    @Test
    public void TC1_BVA()
    {
        Carte c = new Carte();
        try {
            c.setTitlu("nu");
            c.setAnAparitie("2019");
            c.adaugaReferent("da");
            c.adaugaCuvantCheie("nou");

            bc.adaugaCarte(c);

            assertTrue(true);
        }catch (Exception ex){
                fail();
        }
    }

    @Test
    public void TC2_BVA()
    {
        Carte c = new Carte();
        try {
            c.setTitlu("mara are mere");
            c.setAnAparitie("2019");
            c.adaugaReferent("autor1");
            c.adaugaReferent("autor2");
            c.adaugaCuvantCheie("amin");

            bc.adaugaCarte(c);

            assertTrue(true);
        }catch (Exception ex){
            if(ex.getMessage().equals("Titlu invalid!"))
                assertTrue(true);
            else
                fail();
        }
    }

    @Test
    public void TC_WB1()
    {
        List<Carte> carti = cr.cautaCarte("");

        assertEquals(6, carti.size());
    }


    @Test
    public void TC_WB2()
    {
        List<Carte> carti = cr.cautaCarte("Mihai");

        assertEquals(1, carti.size());
    }


    @Test
    public void TC_WB3()
    {
        List<Carte> carti = cr.cautaCarte("blablalba");

        assertEquals(0, carti.size());
    }

}
