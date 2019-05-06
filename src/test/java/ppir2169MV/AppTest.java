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

            cr.adaugaCarte(c);
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

    @Test
    public void TestF03Valid()
    {
        try {

            Carte c = new Carte();
            c.setTitlu("aaaaa");
            c.setAnAparitie("1020");
            c.adaugaReferent("aaaaa");
            c.adaugaCuvantCheie("amin");

            cr.adaugaCarte(c);

            Carte c1 = new Carte();
            c1.setTitlu("bbbbba");
            c1.setAnAparitie("1020");
            c1.adaugaReferent("bbbbb");
            c1.adaugaCuvantCheie("amin");

            cr.adaugaCarte(c1);
        }catch (Exception ex){
            fail();
        }

        assertEquals(2, cr.getCartiOrdonateDinAnul("1020").size());
        assertEquals(cr.getCartiOrdonateDinAnul("1020").get(0).getTitlu(),"aaaaa");
    }

    @Test
    public void TestF03NonValid()
    {
        try {

            Carte c = new Carte();
            c.setTitlu("aaaaa");
            c.setAnAparitie("1020");
            c.adaugaReferent("aaaaa");
            c.adaugaCuvantCheie("amin");

            cr.adaugaCarte(c);

            Carte c1 = new Carte();
            c1.setTitlu("bbbbba");
            c1.setAnAparitie("1020");
            c1.adaugaReferent("bbbbb");
            c1.adaugaCuvantCheie("amin");

            cr.adaugaCarte(c1);
        }catch (Exception ex){
            fail();
        }

        assertEquals(0, cr.getCartiOrdonateDinAnul("102220").size());
    }
}
