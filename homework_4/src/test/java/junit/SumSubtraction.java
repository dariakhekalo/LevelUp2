package junit;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// TODO А какой именно калюкулятор тестируется?
import ru.levelup.qaat.test.Calc;


public class SumSubtraction {

    private Calc calc;

    @Before
    public  void setUp() {
        calc = new Calc();
    }
    @Test
    public void sumIntTest(){

        int result = calc.sum(2,2);
        assertEquals(4,result);

    }
    @Test
    public void subIntTest() {

        int result = calc.sub(66, 13);
        assertEquals(53, result);
    }

    @Test
    public void subDoubleTest() {

        double result = calc.subDouble(97.14, 13.2);
        assertEquals(83.94, result,0.1);
    }

    @Test
    public void sumDoubleTest() {

        double result = calc.sumDouble(66.56, 13.3);
        assertEquals(79.86, result,0.3);
    }


    @After
        public void tearDown() {
            System.out.println("sum, sub  works");
            calc = null;
        }
    }
