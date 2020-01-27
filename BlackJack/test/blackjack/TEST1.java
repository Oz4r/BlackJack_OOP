
package blackjack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janeczka
 */
public class TEST1 {
    
    public TEST1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void pasiimtKorta(){
        Dileris dealer = new Dileris();
        dealer.addKorta(10);
        assertEquals(10,dealer.getTaskai());
    }
    
    @Test
    public void pridetiKorta(){
        Dileris dealer = new Dileris();
        dealer.addKorta(1);
        assertEquals(1,dealer.kortos.size());
    }
    
    @Test
    public void piniguLaimejimas(){
        Losejas client = new Losejas();
        client.laimejo(200);
        assertEquals(700,client.getPinigai(),0.01);
    }
    
    @Test
    public void piniguPralaimejimas(){
        Losejas client = new Losejas();
        client.pralaimejo(200);
        assertEquals(300,client.getPinigai(),0.01);
    }
    
    @Test
    public void kaladesUzpildymas(){
        KortuMalka kortuMalka = new KortuMalka();
        kortuMalka.naujaKortuMalka();
        assertEquals(52,kortuMalka.getKortos().size());
    }
}
