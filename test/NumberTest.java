
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Number;

public class NumberTest {

    private Number a;
    private Number b;
    private Number c;
    private Number d;
    private Number e;
    private Number f;
    private Number g;
    private Number h;
    private Number i;

    @Before
    public void setUp() {
        a = new Number(8);
        b = new Number(8, 4);
        c = new Number(8, 2);
        d = new Number(5, 7);
        e = new Number(0.98);
        f = new Number(3.456);
        g = new Number(0454.09332);
        h = new Number(-5, 4);
        i = new Number(-15, 11);
    }

    @Test
    public void getNumeratorTest() {
        assertEquals(a.getNumerator(), 8);
        assertEquals(d.getNumerator(), 5);
        assertEquals(e.getNumerator(), 49);
        assertEquals(g.getNumerator(), 11352333);
    }

    @Test
    public void getDenominatorTest() {
        assertEquals(a.getDenominator(), 1);
        assertEquals(d.getDenominator(), 7);
        assertEquals(e.getDenominator(), 50);
        assertEquals(g.getDenominator(), 25000);
    }

    @Test
    public void addTest() {
        Number n = a.add(c);
        long numerator = n.getNumerator();
        long denominator = n.getDenominator();
        assertEquals(numerator, 12);
        assertEquals(denominator, 1);

        n = e.add(f);
        numerator = n.getNumerator();
        denominator = n.getDenominator();

        assertEquals(numerator, 1109);
        assertEquals(denominator, 250);
    }

    @Test
    public void subTest() {
        Number n = a.sub(c);
        long numerator = n.getNumerator();
        long denominator = n.getDenominator();
        assertEquals(numerator, 4);
        assertEquals(denominator, 1);

        n = e.sub(f);
        numerator = n.getNumerator();
        denominator = n.getDenominator();
        assertEquals(numerator, -619);
        assertEquals(denominator, 250);

        n = b.sub(b);
        numerator = n.getNumerator();
        denominator = n.getDenominator();
        assertEquals(numerator, 0);
        assertEquals(denominator, 1);

        n = h.sub(a);
        numerator = n.getNumerator();
        denominator = n.getDenominator();
        assertEquals(numerator, -37);
        assertEquals(denominator, 4);

        n = h.sub(h);
        numerator = n.getNumerator();
        denominator = n.getDenominator();
        assertEquals(numerator, 0);
        assertEquals(denominator, 2);
        
        n = h.sub(i);
        numerator = n.getNumerator();
        denominator = n.getDenominator();
        assertEquals(numerator, 5);
        assertEquals(denominator, 44);
    }
    
    @Test
    public void equalsTest() {
        assertTrue((a.equals(a)));
        assertTrue((b.equals(b)));
        assertTrue((c.equals(c)));
        assertFalse((a.equals(d)));
        assertFalse((b.equals(d)));
        assertFalse((c.equals(a)));
    }

    @After
    public void tearDown() {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
    }

}
