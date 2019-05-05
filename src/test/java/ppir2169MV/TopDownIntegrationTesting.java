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
public class TopDownIntegrationTesting
{

    CartiRepoInterface cr = new CartiRepoMock();
    BibliotecaCtrl bc = new BibliotecaCtrl(cr);


    @Test
    public void TestA() throws Exception {
        int size = cr.getCarti().size();
        Carte c = new Carte();
        try {
            c.setTitlu("test");
            c.setAnAparitie("1919");
            c.adaugaReferent("Rebreanu");
            c.adaugaCuvantCheie("sapa");
            c.adaugaCuvantCheie("mort");

            cr.adaugaCarte(c);
        }catch (Exception ex){
            fail();
        }

        assertEquals(cr.getCarti().size(), size + 1);
    }

    @Test
    public void TestB()
    {
        Carte c = new Carte();
        try {
            c.setTitlu("Test2");
            c.setAnAparitie("1000");
            c.adaugaReferent("Nimeni");
            c.adaugaCuvantCheie("doamne");

            c.adaugaCuvantCheie("ajuta");

            cr.adaugaCarte(c);
        }catch (Exception ex){
            fail();
        }

        assertEquals(1, cr.cautaCarte("Nimeni").size());
    }

    @Test
    public void TestC()
    {
        try {

            Carte c = new Carte();
            c.setTitlu("aaa");
            c.setAnAparitie("1010");
            c.adaugaReferent("aaa");
            c.adaugaCuvantCheie("amin");

            cr.adaugaCarte(c);

            Carte c1 = new Carte();
            c1.setTitlu("bbbb");
            c1.setAnAparitie("1010");
            c1.adaugaReferent("bbbb");
            c1.adaugaCuvantCheie("amin");

            cr.adaugaCarte(c1);
        }catch (Exception ex){
            fail();
        }

        assertEquals(2, cr.getCartiOrdonateDinAnul("1010").size());
        assertEquals(cr.getCartiOrdonateDinAnul("1010").get(0).getTitlu(),"aaa");
    }

    @Test
    public void TestPA() throws Exception {
        int size = bc.getCarti().size();
        Carte c = new Carte();
        try {
            c.setTitlu("test");
            c.setAnAparitie("1919");
            c.adaugaReferent("Rebreanu");
            c.adaugaCuvantCheie("sapa");
            c.adaugaCuvantCheie("mort");

            bc.adaugaCarte(c);
        }catch (Exception ex){
            fail();
        }

        assertEquals(bc.getCarti().size(), size + 1);
    }

    @Test
    public void TestPAB() throws Exception {
        int size = bc.getCarti().size();
        Carte c = new Carte();
        try {
            c.setTitlu("test");
            c.setAnAparitie("1919");
            c.adaugaReferent("teapa");
            c.adaugaCuvantCheie("sapa");
            c.adaugaCuvantCheie("mort");

            bc.adaugaCarte(c);
        }catch (Exception ex){
            fail();
        }

        assertEquals(bc.getCarti().size(), size + 1);

        assertEquals(bc.cautaCarte("teapa").get(0).getTitlu(), "test");
    }

    @Test
    public void TestPABC() throws Exception {
        int size = bc.getCarti().size();

        try {

            Carte c = new Carte();
            c.setTitlu("aaaa");
            c.setAnAparitie("1210");
            c.adaugaReferent("aaaa");
            c.adaugaCuvantCheie("amin");

            bc.adaugaCarte(c);

            Carte c1 = new Carte();
            c1.setTitlu("bbbba");
            c1.setAnAparitie("1210");
            c1.adaugaReferent("bbbbb");
            c1.adaugaCuvantCheie("amin");

            bc.adaugaCarte(c1);
        }catch (Exception ex){
            fail();
        }

        assertEquals(bc.getCarti().size(), size + 2);

        assertEquals(1, bc.cautaCarte("aaaa").size());

        assertEquals(2, bc.getCartiOrdonateDinAnul("1210").size());

        assertEquals(bc.getCartiOrdonateDinAnul("1210").get(0).getTitlu(),"aaaa");

    }

}
